package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.CartItemRequest;
import com.onlinebookstore.entity.*;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository,
                       CartItemRepository cartItemRepository,
                       BookRepository bookRepository,
                       UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> createCartForUser(userId));
    }

    public Cart addItemToCart(Long userId, CartItemRequest request) {
        Cart cart = getCartByUserId(userId);
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: " + request.getBookId()));

        if (book.getStock() < request.getQuantity()) {
            throw new BusinessException("INSUFFICIENT_STOCK", "Book stock insufficient, current stock: " + book.getStock());
        }

        Optional<CartItem> existingItem = cartItemRepository.findByCartIdAndBookId(cart.getId(), book.getId());
        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            int newQty = item.getQuantity() + request.getQuantity();
            if (book.getStock() < newQty) {
                throw new BusinessException("INSUFFICIENT_STOCK", "Book stock insufficient, current stock: " + book.getStock());
            }
            item.setQuantity(newQty);
            cartItemRepository.save(item);
        } else {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setBook(book);
            item.setQuantity(request.getQuantity());
            item.setUnitPrice(book.getPrice());
            cart.addCartItem(item);
            cartRepository.save(cart);
        }
        return cart;
    }

    public Cart updateCartItemQuantity(Long userId, Long itemId, Integer quantity) {
        Cart cart = getCartByUserId(userId);
        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("CART_NOT_FOUND", "Cart item not found with id: " + itemId));

        if (!item.getCart().getId().equals(cart.getId())) {
            throw new BusinessException("CART_NOT_FOUND", "Cart item does not belong to current user");
        }

        if (quantity <= 0) {
            cart.removeCartItem(item);
            cartItemRepository.delete(item);
        } else {
            if (item.getBook().getStock() < quantity) {
                throw new BusinessException("INSUFFICIENT_STOCK", "Book stock insufficient");
            }
            item.setQuantity(quantity);
            cartItemRepository.save(item);
        }
        return cart;
    }

    public Cart removeItemFromCart(Long userId, Long itemId) {
        Cart cart = getCartByUserId(userId);
        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("CART_NOT_FOUND", "Cart item not found with id: " + itemId));

        if (!item.getCart().getId().equals(cart.getId())) {
            throw new BusinessException("CART_NOT_FOUND", "Cart item does not belong to current user");
        }

        cart.removeCartItem(item);
        cartItemRepository.delete(item);
        return cart;
    }

    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        List<CartItem> items = cart.getCartItems();
        cart.getCartItems().clear();
        cartItemRepository.deleteAll(items);
        cartRepository.save(cart);
    }

    private Cart createCartForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND", "User not found with id: " + userId));
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}
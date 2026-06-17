package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.BookRequest;
import com.onlinebookstore.entity.Book;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.BookRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @CacheEvict(value = "books", allEntries = true)
    public Book createBook(BookRequest request) {
        if (bookRepository.findByIsbn(request.getIsbn()).isPresent()) {
            throw new BusinessException("DUPLICATE_ISBN", "ISBN already exists: " + request.getIsbn());
        }
        Book book = toEntity(request);
        return bookRepository.save(book);
    }

    @Cacheable(value = "books", key = "#id")
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: " + id));
    }

    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> getBooksByCategory(String category, Pageable pageable) {
        return bookRepository.findByCategory(category, pageable);
    }

    public Page<Book> searchBooksByTitle(String keyword, Pageable pageable) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    public Page<Book> searchBooksByAuthor(String author, Pageable pageable) {
        return bookRepository.findByAuthorContainingIgnoreCase(author, pageable);
    }

    @CacheEvict(value = "books", key = "#id")
    public Book updateBook(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: " + id));
        applyUpdates(book, request);
        return bookRepository.save(book);
    }

    @CacheEvict(value = "books", key = "#id")
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @CacheEvict(value = "books", key = "#bookId")
    public void deductStock(Long bookId, Integer quantity) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: " + bookId));
        if (book.getStock() < quantity) {
            throw new BusinessException("INSUFFICIENT_STOCK", "Book stock insufficient, current stock: " + book.getStock());
        }
        book.setStock(book.getStock() - quantity);
        bookRepository.save(book);
    }

    @CacheEvict(value = "books", key = "#bookId")
    public void restoreStock(Long bookId, Integer quantity) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: " + bookId));
        book.setStock(book.getStock() + quantity);
        bookRepository.save(book);
    }

    private Book toEntity(BookRequest request) {
        Book book = new Book();
        applyUpdates(book, request);
        return book;
    }

    private void applyUpdates(Book book, BookRequest request) {
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublisher(request.getPublisher());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());
        book.setCategory(request.getCategory());
        book.setCoverImageUrl(request.getCoverImageUrl());
    }
}
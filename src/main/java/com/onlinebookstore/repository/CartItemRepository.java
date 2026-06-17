package com.onlinebookstore.repository;

import com.onlinebookstore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * 购物车项数据访问层。
 * <p>提供购物车项的 CRUD 及按购物车和图书查询的能力。</p>
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    /**
     * 在指定购物车中查找特定图书的购物车项。
     * @param cartId 购物车 ID
     * @param bookId 图书 ID
     * @return Optional 包装的购物车项
     */
    Optional<CartItem> findByCartIdAndBookId(Long cartId, Long bookId);
}

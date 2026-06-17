package com.onlinebookstore.repository;

import com.onlinebookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * 购物车数据访问层。
 * <p>提供按用户 ID 查找购物车的能力。</p>
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    /**
     * 根据用户 ID 查找购物车。
     * @param userId 用户 ID
     * @return Optional 包装的购物车
     */
    Optional<Cart> findByUserId(Long userId);
}

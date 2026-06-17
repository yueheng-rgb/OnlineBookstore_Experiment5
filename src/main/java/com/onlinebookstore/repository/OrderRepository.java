package com.onlinebookstore.repository;

import com.onlinebookstore.entity.Order;
import com.onlinebookstore.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 订单数据访问层。
 * <p>提供订单的分页查询、按用户和状态筛选的能力。</p>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * 按用户 ID 分页查询订单，按创建时间降序排列。
     * @param userId 用户 ID
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Order> findByUserIdOrderByCreatedAtDesc(Long userId, Pageable pageable);

    /**
     * 按用户 ID 和订单状态查询订单。
     * @param userId 用户 ID
     * @param status 订单状态
     * @return 订单列表
     */
    List<Order> findByUserIdAndStatus(Long userId, OrderStatus status);
}

package com.onlinebookstore.repository;

import com.onlinebookstore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 订单明细数据访问层。
 * <p>提供按订单 ID 查询订单明细的能力。</p>
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * 根据订单 ID 查询所有订单明细。
     * @param orderId 订单 ID
     * @return 订单明细列表
     */
    List<OrderItem> findByOrderId(Long orderId);
}

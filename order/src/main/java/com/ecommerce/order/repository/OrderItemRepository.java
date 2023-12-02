package com.ecommerce.order.repository;

import com.ecommerce.order.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,Long> {
}

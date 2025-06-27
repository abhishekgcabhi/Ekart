package com.eCart.eCart.repository;

import com.eCart.eCart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository-Copy extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}

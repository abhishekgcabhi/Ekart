package com.eCart.eCart.service;
import com.eCart.eCart.entity.Product;
import com.eCart.eCart.entity.Order;
import com.eCart.eCart.entity.User;
import com.eCart.eCart.repository.OrderRepository;
import com.eCart.eCart.repository.ProductRepository;
import com.eCart.eCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(Long userId, List<Long> productIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Double totalAmount = productIds.stream()
                .map(productRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .mapToDouble(Product::getPrice)
                .sum();

        Order order = new Order();
        order.setUser(user);
        order.setProductIds(productIds);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
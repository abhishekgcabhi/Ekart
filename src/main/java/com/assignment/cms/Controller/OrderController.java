package com.assignment.cms.Controller;

import com.assignment.cms.Entity.Order;
import com.assignment.cms.Entity.User;
import com.assignment.cms.Service.OrderService;
import com.assignment.cms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        order.setUser(user);

        return ResponseEntity.ok(orderService.placeOrder(order));
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/myOrder")
    public ResponseEntity<List<Order>> myOrders(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderService.getOrdersByUser(user));
    }
}
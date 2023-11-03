package com.imbuka.restaurantservice.controller;

import com.imbuka.restaurantservice.dto.OrderResponseDTO;
import com.imbuka.restaurantservice.entity.Order;
import com.imbuka.restaurantservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final OrderService orderService;

    @GetMapping
    public String greetingMessage(){
        return orderService.greeting();
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/orders/status/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable Integer orderId) {
        return orderService.findOrderByOrderId(orderId);
    }
}

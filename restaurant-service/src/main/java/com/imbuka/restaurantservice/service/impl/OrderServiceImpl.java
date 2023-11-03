package com.imbuka.restaurantservice.service.impl;


import com.imbuka.restaurantservice.dto.OrderResponseDTO;
import com.imbuka.restaurantservice.entity.Order;
import com.imbuka.restaurantservice.repository.OrderRepository;
import com.imbuka.restaurantservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public String greeting() {
        return "Welcome to Idara Restaurant Service";
    }

    public OrderResponseDTO findOrderByOrderId(Integer orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

    @Override
    public Order saveOrder(Order order) {
         orderRepository.save(order);
         return order;

    }


}


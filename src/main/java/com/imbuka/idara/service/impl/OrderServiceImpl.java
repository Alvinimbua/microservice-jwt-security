package com.imbuka.idara.service.impl;

import com.imbuka.idara.client.RestaurantServiceClient;
import com.imbuka.idara.dto.OrderResponseDTO;
import com.imbuka.idara.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RestaurantServiceClient restaurantServiceClient;

    @Override
    public String greeting() {
        return "Welcome to Idara App Service";
    }

    @Override
    public OrderResponseDTO checkOrderStatus(Integer orderId) {
        return restaurantServiceClient.fetchOrderStatus(orderId);
    }
}


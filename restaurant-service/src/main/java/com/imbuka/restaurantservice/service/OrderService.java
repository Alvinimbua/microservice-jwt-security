package com.imbuka.restaurantservice.service;


import com.imbuka.restaurantservice.dto.OrderResponseDTO;
import com.imbuka.restaurantservice.entity.Order;

public interface OrderService {

    String greeting();

    OrderResponseDTO findOrderByOrderId(Integer orderId);

    Order saveOrder(Order order);


}

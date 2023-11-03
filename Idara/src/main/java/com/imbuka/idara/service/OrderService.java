package com.imbuka.idara.service;

import com.imbuka.idara.dto.OrderResponseDTO;

public interface OrderService {

    String greeting();

    OrderResponseDTO checkOrderStatus(Integer orderId);
}

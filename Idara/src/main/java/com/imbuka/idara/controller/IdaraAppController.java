package com.imbuka.idara.controller;

import com.imbuka.idara.dto.OrderResponseDTO;
import com.imbuka.idara.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/idara")
@RequiredArgsConstructor
public class IdaraAppController {

    private final OrderService orderService;

    @GetMapping("/home")
    public String greeetingMessage() {
        return orderService.greeting();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkOrderStatus(@PathVariable Integer orderId) {
        return orderService.checkOrderStatus(orderId);
    }
}

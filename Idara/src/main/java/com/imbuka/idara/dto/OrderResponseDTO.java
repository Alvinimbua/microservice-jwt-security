package com.imbuka.idara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {
    private Integer orderId;
    private String name;
    private int quantity;
    private double price;
    private Date orderDate;
    private String status;
    private int estimateDeliveryWindow;
}

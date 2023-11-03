package com.imbuka.idara.client;

import com.imbuka.idara.dto.OrderResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class RestaurantServiceClient {

    private RestTemplate restTemplate;

    public OrderResponseDTO fetchOrderStatus(Integer orderId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId, OrderResponseDTO.class);
    }
}

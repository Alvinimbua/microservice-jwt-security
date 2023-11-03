package com.imbuka.restaurantservice.repository;


import com.imbuka.restaurantservice.dto.OrderResponseDTO;
import com.imbuka.restaurantservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    OrderResponseDTO findOrderByOrderId(Integer orderId);
}

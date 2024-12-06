package com.example.pizza.Dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdersDTO {
    private Long order_id;
    private Long item_id;
    private Long quantity;
    private LocalDateTime order_time;
    private Long bill_id;
}

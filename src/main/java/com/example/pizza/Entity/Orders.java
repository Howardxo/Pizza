package com.example.pizza.Entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Orders {
    private Long order_id;
    private Long item_id;
    private Long quantity;
    private LocalDateTime order_time;
    private Long bill_id;
}

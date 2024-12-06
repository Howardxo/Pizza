package com.example.pizza.Dto;

import lombok.Data;

@Data
public class itemsDTO {
    private Long item_id;
    private String name;
    private String description;
    private String image;
    private double price;
    private Long detail_id;
    private String title;
}

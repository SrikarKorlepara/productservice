package com.scaler.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;  // we are taking it like this because fake store is sending a String
    private String description;
    private String image;
}

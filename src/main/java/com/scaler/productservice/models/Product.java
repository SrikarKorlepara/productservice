package com.scaler.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter  // from lombok. automatically adds the getter to the variables
@Setter  // automatically adds the Setter to the variables
// these will be public methods
@Entity

public class Product extends BaseModel{

    private String title;
    @ManyToOne
    private Category category;
    private double price;
    private String description;
    private String imageURL;
}

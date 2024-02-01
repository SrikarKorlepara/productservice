package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String imageURL;
    @ManyToOne()
    private Category category;
}

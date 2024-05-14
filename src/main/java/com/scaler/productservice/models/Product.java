package com.scaler.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String imageURL;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    //@JsonIgnore
    private Category category;
    private int numberOfSales;
}

package com.scaler.productservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    //@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
    // try to get the list of products as well along with the category without
    // products and category internally infinitely referencing each other.
    private String name;
    private String description;
}





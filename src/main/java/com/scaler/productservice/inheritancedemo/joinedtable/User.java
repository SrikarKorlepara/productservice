package com.scaler.productservice.inheritancedemo.joinedtable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED) //instead of this statement we can use

public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}

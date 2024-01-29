package com.scaler.productservice.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
@PrimaryKeyJoinColumn(name = "user_id") //this will act as foreign key to the user table
public class Mentor extends User {
//    @Id
//    private Long id;
// if we want to have seperate id for mentor we will have to add
// it like this and remove the PrimaryKeyJoinColumn annotation
    private double averageRating;

}

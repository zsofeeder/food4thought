package com.food4thought.food4thought.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Food {
    @Id
    @GeneratedValue
    private Long foodId;
    private String foodName;
    private Double foodPrice;
    private Boolean isAvailable;
    private List<String> ingredients;
}

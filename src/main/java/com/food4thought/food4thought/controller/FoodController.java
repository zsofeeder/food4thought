package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.model.Food;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodController {

    @GetMapping
    public List<Food> GetAllFood() {
        //todo
        return new ArrayList<>();
    }
}

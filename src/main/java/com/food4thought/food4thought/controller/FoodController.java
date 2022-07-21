package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.model.Food;
import com.food4thought.food4thought.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/menu")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @PostMapping("/menu")
    public ResponseEntity<Food> addFood(@RequestBody Food food) throws Exception {

        Food f = foodService.createFood(food);
        if (f == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        }
    }


}

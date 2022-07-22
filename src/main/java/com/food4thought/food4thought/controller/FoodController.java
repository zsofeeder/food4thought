package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.model.Food;
import com.food4thought.food4thought.service.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/menu")
public class FoodController {
    private final FoodService foodService;

    @GetMapping()
    public List<Food> getAllFood() {
        return foodService.getFoods();
    }

    @PostMapping()
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food f = new Food();
        try {
            f = foodService.addFood(food);
        } catch (Exception e) {
            log.error("Error while saving food", e);

        }
        return new ResponseEntity<>(f, HttpStatus.CREATED);

    }


}

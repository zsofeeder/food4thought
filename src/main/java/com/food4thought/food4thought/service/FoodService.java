package com.food4thought.food4thought.service;

import com.food4thought.food4thought.model.Food;
import com.food4thought.food4thought.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public Food createFood(Food food){
        return foodRepository.save(food);
    }

}

package com.food4thought.food4thought.service;

import com.food4thought.food4thought.model.Food;
import com.food4thought.food4thought.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public Food addFood(Food food){
        return foodRepository.save(food);
    }

}

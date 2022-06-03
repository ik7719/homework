package com.homework.start0603.service;

import com.homework.start0603.dto.FoodDto;
import com.homework.start0603.model.Food;
import com.homework.start0603.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService
{
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository)
    {
        this.foodRepository = foodRepository;
    }

    public void registerMenu(FoodDto foodDto)
    {
        String foodName = foodDto.getFoodName();
        int foodPrice = foodDto.getFoodPrice();

        Food food = new Food(foodName, foodPrice);

        foodRepository.save(food);
    }


}

package com.homework.start0603.service;

import com.homework.start0603.dto.FoodDto;
import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.model.Food;
import com.homework.start0603.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodService
{
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository)
    {
        this.foodRepository = foodRepository;
    }

    public void registerMenu(FoodDto foodDto, RestaurantIntegrationDto restaurantIntegrationDto)
    {
        String foodName = foodDto.getFoodName();
        int foodPrice = foodDto.getFoodPrice();
        Long id = restaurantIntegrationDto.getId();

        Food food = new Food(foodName, foodPrice, id);

        int foodPriceUnit = 100;

        if(foodPrice % foodPriceUnit == 0){
            foodRepository.save(food);
        } else {
            log.info("가격을 다시 입력해주세요.");
        }
    }
}

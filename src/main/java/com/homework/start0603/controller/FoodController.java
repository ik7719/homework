package com.homework.start0603.controller;

import com.homework.start0603.dto.FoodDto;
import com.homework.start0603.model.RestaurantIntegration;
import com.homework.start0603.repository.FoodRepository;
import com.homework.start0603.repository.RestaurantIntegrationRepository;
import com.homework.start0603.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FoodController
{
    private final FoodService foodService;
    private final FoodRepository foodRepository;
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public String createMenu(@PathVariable RestaurantIntegration restaurantIntegration,
            @Valid @RequestBody FoodDto foodDto)
    {
        foodService.registerMenu(foodDto);
        return "";
    }
}

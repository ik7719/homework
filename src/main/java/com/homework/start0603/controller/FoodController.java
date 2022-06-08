package com.homework.start0603.controller;

import com.homework.start0603.dto.FoodDto;
import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.model.Food;
import com.homework.start0603.repository.RestaurantIntegrationRepository;
import com.homework.start0603.service.FoodService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FoodController
{
    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public String createMenu
            (@PathVariable Long restaurantId,
            @Valid @RequestBody FoodDto foodDto)
    {
        log.info("{}", restaurantId); // "{}" : 자동으로 맵핑
        foodService.registerMenu(foodDto);
        return "";
    }
}

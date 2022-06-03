package com.homework.start0603.controller;

import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.service.RestaurantIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RestaurantIntegrationController
{
    private final RestaurantIntegrationService restaurantIntegrationService;

    @Autowired
    public RestaurantIntegrationController(RestaurantIntegrationService restaurantIntegrationService)
    {
        this.restaurantIntegrationService = restaurantIntegrationService;
    }

    @PostMapping("/restaurants")
    public String createRestaurant(@Valid @RequestBody RestaurantIntegrationDto restaurantIntegrationDto)
    {
        restaurantIntegrationService.registerRe(restaurantIntegrationDto);
        return "등록이 완료 되었습니다.";
    }
}

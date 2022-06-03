package com.homework.start0603.controller;

import com.homework.start0603.Dto.RestaurantIntegrationDto;
import com.homework.start0603.service.RestaurantIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//@RequiredArgsConstructor
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
    public ResponseEntity<RestaurantIntegrationDto> createRestaurant(@Valid RestaurantIntegrationDto restaurantIntegrationDto)
    {
        restaurantIntegrationService.registerRe(restaurantIntegrationDto);
        return ResponseEntity.ok(restaurantIntegrationDto);
    }
}

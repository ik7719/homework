package com.homework.start0603.controller;

import com.homework.start0603.Dto.RestaurantIntegrationDto;
import com.homework.start0603.model.RestaurantIntegration;
import com.homework.start0603.repository.RestaurantIntegrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class RestaurantIntegrationController
{
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;
    @PostMapping("/restaurants")
    public ResponseEntity<RestaurantIntegrationDto> createRestaurant(@Valid RestaurantIntegrationDto restaurantIntegrationDto)
    {
        RestaurantIntegrationDto restaurant = restaurantService.registerRe(restaurantIntegrationDto);
        return ResponseEntity.ok(restaurant);
    }
}

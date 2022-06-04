package com.homework.start0603.controller;

import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.model.RestaurantIntegration;
import com.homework.start0603.repository.RestaurantIntegrationRepository;
import com.homework.start0603.service.RestaurantIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RestaurantIntegrationController
{
    private final RestaurantIntegrationService restaurantIntegrationService;
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;


    @PostMapping("/restaurant/register")
    public RestaurantIntegrationDto createRestaurant(@Valid @RequestBody RestaurantIntegrationDto restaurantIntegrationDto)
    {
        return restaurantIntegrationService.registerRe(restaurantIntegrationDto);

        // todo : 서비스에서 조건 주지말고 컨트롤러에서 조건 주는 방향으로
    }

    @GetMapping("/restaurants")
    public List<RestaurantIntegration> getLists()
    {
        return restaurantIntegrationRepository.findAll();
    }
}

package com.homework.start0603.controller;

import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.model.RestaurantIntegration;
import com.homework.start0603.repository.RestaurantIntegrationRepository;
import com.homework.start0603.service.RestaurantIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantIntegrationController
{
    private final RestaurantIntegrationService restaurantIntegrationService;
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;

    @PostMapping("/restaurants/register")
    public String createRestaurant(@Valid @RequestBody RestaurantIntegrationDto restaurantIntegrationDto)
    {
        restaurantIntegrationService.registerRe(restaurantIntegrationDto);
        return "등록이 완료 되었습니다.";
    }

    @GetMapping("/restaurants")
    public List<RestaurantIntegration> getLists()
    {
        return restaurantIntegrationRepository.findAll();
    }
}

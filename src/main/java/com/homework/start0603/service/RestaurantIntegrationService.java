package com.homework.start0603.service;

import com.homework.start0603.Dto.RestaurantIntegrationDto;
import com.homework.start0603.model.RestaurantIntegration;
import com.homework.start0603.repository.RestaurantIntegrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantIntegrationService
{
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;

    @Autowired
    public RestaurantIntegrationService(RestaurantIntegrationRepository restaurantIntegrationRepository)
    {
        this.restaurantIntegrationRepository = restaurantIntegrationRepository;
    }

    public void registerRe(RestaurantIntegrationDto restaurantIntegrationDto)
    {
        String name = restaurantIntegrationDto.getName();
        int minOrderFee = restaurantIntegrationDto.getMinOrderPrice();
        int deliveryFee = restaurantIntegrationDto.getDeliveryFee();

        RestaurantIntegration restaurantIntegration = new RestaurantIntegration(name, minOrderFee, deliveryFee);

        restaurantIntegrationRepository.save(restaurantIntegration);
    }
}

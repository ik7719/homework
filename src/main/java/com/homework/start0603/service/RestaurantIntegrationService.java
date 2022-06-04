package com.homework.start0603.service;

import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.model.RestaurantIntegration;
import com.homework.start0603.repository.RestaurantIntegrationRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class RestaurantIntegrationService
{
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;

    @Autowired
    public RestaurantIntegrationService(RestaurantIntegrationRepository restaurantIntegrationRepository)
    {
        this.restaurantIntegrationRepository = restaurantIntegrationRepository;
    }

    @Transactional
    public RestaurantIntegrationDto registerRe(RestaurantIntegrationDto restaurantIntegrationDto)
    {
        String name = restaurantIntegrationDto.getName();
        int minOrderFee = restaurantIntegrationDto.getMinOrderPrice();
        int deliveryFee = restaurantIntegrationDto.getDeliveryFee();

        RestaurantIntegration restaurantIntegration = new RestaurantIntegration(name, minOrderFee, deliveryFee);

        int minOrderFeeUnit = 100;
        int deliveryFeeUnit = 500;

        if(minOrderFee % minOrderFeeUnit == 0 && deliveryFee % deliveryFeeUnit == 0)
        {
            restaurantIntegrationRepository.save(restaurantIntegration);
            restaurantIntegrationDto.setRestaurantId(restaurantIntegration.getRestaurantId());
            return restaurantIntegrationDto;
        } else {
            throw new IllegalArgumentException("값을 다시 입력해주세요.");
        }
    }
}

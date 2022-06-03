package com.homework.start0603.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter @Setter
public class RestaurantIntegrationDto
{
    private String name;

    @Min(value = 1000)
    @Max(value = 100000)
    private int minOrderPrice;

    @Min(value = 0)
    @Max(value = 10000)
    private int deliveryFee;

    public RestaurantIntegrationDto(String name, int minOrderPrice, int deliveryFee)
    {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}

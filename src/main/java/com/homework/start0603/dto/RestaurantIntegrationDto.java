package com.homework.start0603.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class RestaurantIntegrationDto
{
    private String name;

    @Range(min = 1000, max = 100000)
    @NotBlank
    private int minOrderPrice;

    @Range(min = 0, max = 10000)
    @NotBlank
    private int deliveryFee;

    public RestaurantIntegrationDto(String name, int minOrderPrice, int deliveryFee)
    {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}

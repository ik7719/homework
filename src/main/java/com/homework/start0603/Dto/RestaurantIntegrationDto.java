package com.homework.start0603.Dto;

import org.hibernate.validator.constraints.Length;

public class RestaurantIntegrationDto
{

    private String name;

    @Length(min = 1000, max = 100000, message = "1000원에서 100000원 입력이 가능합니다.")
    private int minOrderPrice;

    @Length(max = 10000, message = "최대 10000원입니다.")
    private int deliveryFee;
}

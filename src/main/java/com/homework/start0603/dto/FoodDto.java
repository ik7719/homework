package com.homework.start0603.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter @Setter
public class FoodDto
{
    private String foodName;

    @Range(min = 100, max = 1000000)
    private int foodPrice;

    public FoodDto(String foodName, int foodPrice)
    {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}

package com.homework.start0603.dto;

import com.homework.start0603.model.RestaurantIntegration;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Builder
@Getter @Setter
public class RestaurantIntegrationDto
{
    private String name;

    @Range(min = 1000, max = 100000)
    private int minOrderPrice;

    @Range(min = 0, max = 10000)
    private int deliveryFee;

    private Long id;

    public RestaurantIntegrationDto(String name, int minOrderPrice, int deliveryFee, Long id)
    {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
        this.id = id;
    }

    public static RestaurantIntegrationDto from(RestaurantIntegration restaurantIntegration)
    {
        if(restaurantIntegration == null) return null;

        return RestaurantIntegrationDto.builder()
                .build();
    }

}

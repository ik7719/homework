package com.homework.start0603.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class RestaurantIntegration
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // 음식점 이름

    @Column(nullable = false)
    private int minOrderPrice; // 최소주문 가격

    @Column(nullable = false)
    private int deliveryFee; // 기본 배달비

    public RestaurantIntegration(String name, int minOrderPrice, int deliveryFee)
    {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }

//    @OneToMany(mappedBy = "parent")
//    private final List<Food> foodList = new ArrayList<>();
//
//    public void addChild(Food food)
//    {
//        foodList.add(food);
//        food.setParent(this);
//    }


}

package com.homework.start0603.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantIntegration
{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "RESTAURANT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FOOD_ID")
    private Food food; // Food Reference

    @Column(nullable = false, unique = true)
    private String name; // 음식점 이름

    @Column(nullable = false)
    private int minOrderPrice; // 최소주문 가격

    @Column(nullable = false)
    private int deliveryFee; // 기본 배달비

    public RestaurantIntegration(String name, int minOrderPrice, int deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}

package com.homework.start0603.model;

import javax.persistence.*;

@Entity
public class RestaurantIntegration
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // 음식점 이름

    @Column(nullable = false)
    private int minOrderPrice; // 최소주문 가격

    @Column(nullable = false)
    private int deliveryFee; // 기본 배달비
}

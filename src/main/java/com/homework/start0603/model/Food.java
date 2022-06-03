package com.homework.start0603.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private int foodPrice;

    public Food(String foodName, int foodPrice)
    {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
}

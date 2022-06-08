package com.homework.start0603.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FOOD_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private RestaurantIntegration restaurentIntegration; // Food Reference

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

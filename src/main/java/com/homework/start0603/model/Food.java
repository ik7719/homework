package com.homework.start0603.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Food
{
    // GenerationType.sequence, generator = "orderfood_A"
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FOOD_ID")
    private Long id;

    @OneToMany(mappedBy = "RestaurentIntegration")
    private List<Food> foods = new ArrayList<>();

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

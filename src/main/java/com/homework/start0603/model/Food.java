//package com.homework.start0603.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter @Setter
//@NoArgsConstructor
//public class Food
//{
//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private RestaurantIntegration parent;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long foodId;
//
//    @Column(nullable = false)
//    private String foodName;
//
//    @Column(nullable = false)
//    private int foodPrice;
//
//    public Food(String foodName, int foodPrice)
//    {
//        this.foodName = foodName;
//        this.foodPrice = foodPrice;
//    }
//}

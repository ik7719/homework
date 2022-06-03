package com.homework.start0603.repository;

import com.homework.start0603.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long>
{

}

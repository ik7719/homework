package com.homework.start0603.controller;

import com.homework.start0603.dto.FoodDto;
import com.homework.start0603.dto.RestaurantIntegrationDto;
import com.homework.start0603.model.Food;
import com.homework.start0603.repository.FoodRepository;
import com.homework.start0603.repository.RestaurantIntegrationRepository;
import com.homework.start0603.service.FoodService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Data
public class FoodController
{
    private final FoodService foodService;
    private final RestaurantIntegrationRepository restaurantIntegrationRepository;
    private final FoodRepository foodRepository;
    private final RestaurantIntegrationDto restaurantIntegrationDto;

    @PostMapping("/restaurant/{id}/food/register")
    public FoodDto createMenu
            (@PathVariable Long id, @Valid @RequestBody FoodDto foodDto) // Dto를 리스트로 받아야 되나?
    {
        // 음식점 id로 findbyid(id)해서 음식점을 가지고 와야함.
//        restaurantIntegrationRepository.findById(id);

        // 등록하려는 음식으로 food.setRestaurantIntegration(가져온 음식점) 해서 음식점을 등록
//        log.info("{}", id); // "{}" : 자동으로 맵핑


        Food food = food.setRestaurantIntegration(restaurantIntegrationRepository.findById(id));

        // food 설정이 완료되면 foodRepository.save(food)해서 음식 등록
        foodRepository.save(food);

        // db에 음식이 정상적으로 등록되는지 확인

//        log.info("{}", id); // "{}" : 자동으로 맵핑
        return foodService.registerMenu(foodDto);
    }
}

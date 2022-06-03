package com.homework.start0603.repository;

import com.homework.start0603.model.RestaurantIntegration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantIntegrationRepository extends
        JpaRepository<RestaurantIntegration, Long>
{
    Optional<RestaurantIntegration> findByName(String name);
}

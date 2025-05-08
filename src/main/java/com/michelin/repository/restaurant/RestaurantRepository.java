package com.michelin.repository.restaurant;
import com.michelin.entity.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // 기본 CRUD 제공 (findAll, findById, save, deleteById 등)
}
package com.michelin.controller.restaurant;

import com.michelin.dto.restaurant.RestaurantDto;
import com.michelin.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // 전체 음식점 조회
    @GetMapping
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // ID로 음식점 조회
    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id);
    }

    // 음식점 등록
    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto dto){
        RestaurantDto created = restaurantService.createRestaurant(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

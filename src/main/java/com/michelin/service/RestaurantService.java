package com.michelin.service;

import com.michelin.dto.RestaurantDto;
import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto getRestaurantById(Long id);
    RestaurantDto createRestaurant(RestaurantDto dto);
}

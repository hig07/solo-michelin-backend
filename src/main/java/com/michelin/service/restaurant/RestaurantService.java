package com.michelin.service.restaurant;

import com.michelin.dto.restaurant.RestaurantDto;
import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto getRestaurantById(Long id);
    RestaurantDto createRestaurant(RestaurantDto dto);
}

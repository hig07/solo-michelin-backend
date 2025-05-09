package com.michelin.service.restaurant;

import com.michelin.dto.restaurant.RestaurantRequest;
import com.michelin.dto.restaurant.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest request);
    List<RestaurantResponse> getAllRestaurants();
    RestaurantResponse getRestaurantById(Long id);
    RestaurantResponse updateRestaurant(Long id, RestaurantRequest request);
    void deleteRestaurant(Long id);
}

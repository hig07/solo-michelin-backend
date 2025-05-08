package com.michelin.service.restaurant;

import com.michelin.dto.restaurant.RestaurantDto;
import com.michelin.entity.restaurant.Restaurant;
import com.michelin.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 음식점을 찾을 수 없습니다: " + id));
        return convertToDto(restaurant);
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setCategory(dto.getCategory());
        restaurant.setMapUrl(dto.getMapUrl());
        restaurant.setAvgRating(dto.getAvgRating());

        Restaurant saved = restaurantRepository.save(restaurant);
        RestaurantDto result = new RestaurantDto();
        result.setId(saved.getId());
        result.setName(saved.getName());
        result.setAddress(saved.getAddress());
        result.setCategory(saved.getCategory());
        result.setMapUrl(saved.getMapUrl());
        result.setAvgRating(saved.getAvgRating());
        return result;
    }

    // DTO <-> Entity 변환
    private RestaurantDto convertToDto(Restaurant entity) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setCategory(entity.getCategory());
        dto.setMapUrl(entity.getMap_url());
        dto.setAvgRating(entity.getAvg_rating());
        return dto;
    }

    private Restaurant convertToEntity(RestaurantDto dto) {
        Restaurant entity = new Restaurant();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setCategory(dto.getCategory());
        entity.setMap_url(dto.getMapUrl());
        entity.setAvg_rating(dto.getAvgRating());
        return entity;
    }
}

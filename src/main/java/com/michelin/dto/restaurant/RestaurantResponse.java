package com.michelin.dto.restaurant;

import com.michelin.entity.restaurant.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestaurantResponse {
    private Long id;
    private String name;
    private String address;
    private String category;
    private String mapUrl;
    private float avgRating;
    private String created;

    public static RestaurantResponse from(Restaurant restaurant){
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .category(restaurant.getCategory())
                .mapUrl(restaurant.getMapUrl())
                .avgRating(restaurant.getAvgRating())
                .build();
    }

}

package com.michelin.dto.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequest {
    @NotBlank(message = "음식점 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    @NotBlank(message = "카테고리는 필수입니다.")
    private String category;

    private String marUrl;

    private String imageUrl;


}

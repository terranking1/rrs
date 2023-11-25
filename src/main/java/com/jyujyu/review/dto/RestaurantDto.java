package com.jyujyu.review.dto;

import com.jyujyu.review.model.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantDto {

    private Long id;
    private String name;
    private String address;
    private String createdAt;
    private String updatedAt;

    public RestaurantDto() {
    }

    public RestaurantDto(Restaurant restaurant) {
        id = restaurant.getId();
        name = restaurant.getName();
        address = restaurant.getAddress();
        createdAt = restaurant.getCreated_at();
        updatedAt = restaurant.getUpdated_at();
    }
}

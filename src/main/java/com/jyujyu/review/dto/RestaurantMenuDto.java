package com.jyujyu.review.dto;

import com.jyujyu.review.model.RestaurantMenu;
import lombok.Getter;

@Getter
public class RestaurantMenuDto {
    private Long id;
    private String name;
    private int price;
    private String createdAt;
    private String updatedAt;

    public RestaurantMenuDto() {
    }

    public RestaurantMenuDto(RestaurantMenu restaurantMenu) {
        id = restaurantMenu.getId();
        name = restaurantMenu.getName();
        price = restaurantMenu.getPrice();
        createdAt = restaurantMenu.getCreated_at();
        updatedAt = restaurantMenu.getUpdated_at();
    }
}

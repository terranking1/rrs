package com.jyujyu.review.dto;

import com.jyujyu.review.model.Restaurant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class RestaurantDetailDto {
    private Long id;
    private String name;
    private String address;
    private String createdAt;
    private String updatedAt;
    private List<RestaurantMenuDto> menus;

    public RestaurantDetailDto() {
    }

    public RestaurantDetailDto(Restaurant restaurant) {
        id = restaurant.getId();
        name = restaurant.getName();
        address = restaurant.getAddress();
        createdAt = restaurant.getCreated_at();
        updatedAt = restaurant.getUpdated_at();
        menus = restaurant.getMenus().stream()
                .map(RestaurantMenuDto::new)
                .collect(Collectors.toList());

    }
}

package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetRestaurantsResponse {

    private List<RestaurantDto> restaurants = new ArrayList<>();

    public GetRestaurantsResponse() {
    }

    public GetRestaurantsResponse(List<RestaurantDto> restaurants) {
        this.restaurants = restaurants;
    }
}

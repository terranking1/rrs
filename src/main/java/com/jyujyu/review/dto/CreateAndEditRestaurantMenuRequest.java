package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateAndEditRestaurantMenuRequest {

    private String name;
    private int price;

    public CreateAndEditRestaurantMenuRequest() {
    }

    @Builder
    public CreateAndEditRestaurantMenuRequest(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

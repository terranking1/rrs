package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateAndEditRestaurantRequest {
    private String name;
    private String address;
    private List<CreateAndEditRestaurantMenuRequest> menus = new ArrayList<>();

    public CreateAndEditRestaurantRequest() {
    }

    @Builder
    public CreateAndEditRestaurantRequest(String name, String address, List<CreateAndEditRestaurantMenuRequest> menus) {
        this.name = name;
        this.address = address;
        this.menus = menus;
    }
}

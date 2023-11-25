package com.jyujyu.review.api;

import com.jyujyu.review.dto.CreateAndEditRestaurantRequest;
import com.jyujyu.review.dto.GetRestaurantsResponse;
import com.jyujyu.review.dto.RestaurantDetailDto;
import com.jyujyu.review.dto.RestaurantDto;
import com.jyujyu.review.model.Restaurant;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDto> getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        List<RestaurantDto> collect = restaurants.stream()
                .map(RestaurantDto::new)
                .collect(Collectors.toList());

        return collect;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailDto getRestaurant(
            @PathVariable Long restaurantId
    ) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        return new RestaurantDetailDto(restaurant);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.createRestaurant(request);

    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);

    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        restaurantService.deleteRestaurant(restaurantId);

    }
}

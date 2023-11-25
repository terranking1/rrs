package com.jyujyu.review.service;

import com.jyujyu.review.dto.CreateAndEditRestaurantRequest;
import com.jyujyu.review.model.Restaurant;
import com.jyujyu.review.model.RestaurantMenu;
import com.jyujyu.review.repository.RestaurantMenuRepository;
import com.jyujyu.review.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuRepository restaurantMenuRepository;

    @Transactional
    public Long createRestaurant(CreateAndEditRestaurantRequest request) {
        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
        restaurantRepository.save(restaurant);

        request.getMenus().forEach((menu) -> {
            RestaurantMenu restaurantMenu = RestaurantMenu.builder()
                    .restaurant(restaurant)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();

            restaurantMenuRepository.save(restaurantMenu);
        });

        return restaurant.getId();
    }

    @Transactional
    public Long editRestaurant(Long id, CreateAndEditRestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 식당입니다.")
        );
        restaurant.changeRestaurant(request.getName(), request.getAddress());
        List<RestaurantMenu> menus = restaurantMenuRepository.findAllByRestaurantId(restaurant.getId());

        restaurantMenuRepository.deleteAll(menus);

        request.getMenus().forEach((menu) -> {
            RestaurantMenu restaurantMenu = RestaurantMenu.builder()
                    .restaurant(restaurant)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();

            restaurantMenuRepository.save(restaurantMenu);
        });

        return restaurant.getId();
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 식당입니다.")
        );

        restaurantRepository.delete(restaurant);
    }

    public List<Restaurant> getRestaurants() {

        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Long id) {

        return restaurantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 식당입니다.")
        );
    }
}

package com.jyujyu.review.repository;

import com.jyujyu.review.model.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {
    List<RestaurantMenu> findAllByRestaurantId(Long restaurantId);
}

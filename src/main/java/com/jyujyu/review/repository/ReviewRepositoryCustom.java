package com.jyujyu.review.repository;

import com.jyujyu.review.dto.GetReviewsByRestaurantRequest;
import com.jyujyu.review.dto.ReviewDto;
import com.jyujyu.review.model.Review;

import java.util.List;

public interface ReviewRepositoryCustom {

    double getAvgScoreByRestaurant(Long restaurantId);
    public List<Review> getReviewsByRestaurant(GetReviewsByRestaurantRequest request);
}

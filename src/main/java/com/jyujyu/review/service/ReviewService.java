package com.jyujyu.review.service;

import com.jyujyu.review.dto.CreateReviewRequest;
import com.jyujyu.review.dto.GetReviewsByRestaurantRequest;
import com.jyujyu.review.dto.GetReviewsByRestaurantResponse;
import com.jyujyu.review.dto.ReviewDto;
import com.jyujyu.review.model.Restaurant;
import com.jyujyu.review.model.Review;
import com.jyujyu.review.repository.RestaurantRepository;
import com.jyujyu.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Long createReview(CreateReviewRequest request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId()).orElseThrow(
                () -> new RuntimeException("존재하지 않는 식당입니다.")
        );

        Review review = Review.builder()
                .restaurant(restaurant)
                .content(request.getContent())
                .score(request.getScore())
                .build();

        reviewRepository.save(review);

        return review.getId();
    }

    @Transactional
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 리뷰입니다.")
        );

        reviewRepository.delete(review);
    }

    public GetReviewsByRestaurantResponse getReviewsByRestaurant(GetReviewsByRestaurantRequest request) {
        List<Review> reviews = reviewRepository.getReviewsByRestaurant(request);
        double avgScore = reviewRepository.getAvgScoreByRestaurant(request.getRestaurantId());
        List<ReviewDto> collect = reviews.stream()
                .map(ReviewDto::new)
                .collect(Collectors.toList());

        return GetReviewsByRestaurantResponse.builder()
                .avgScore(avgScore)
                .reviews(collect)
                .offset(request.getOffset())
                .limit(request.getSize())
                .build();
    }
}

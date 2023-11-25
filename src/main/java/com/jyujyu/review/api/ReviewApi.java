package com.jyujyu.review.api;

import com.jyujyu.review.dto.CreateReviewRequest;
import com.jyujyu.review.dto.GetReviewsByRestaurantRequest;
import com.jyujyu.review.dto.GetReviewsByRestaurantResponse;
import com.jyujyu.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(
            @RequestBody CreateReviewRequest request
    ) {
        reviewService.createReview(request);
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(
            @PathVariable Long reviewId
    ) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public GetReviewsByRestaurantResponse getReviewByRestaurant(
            @PathVariable Long restaurantId,
            @RequestParam Integer page
    ) {
        GetReviewsByRestaurantRequest request = GetReviewsByRestaurantRequest.builder()
                .restaurantId(restaurantId)
                .page(page)
                .build();
        return reviewService.getReviewsByRestaurant(request);
    }
}

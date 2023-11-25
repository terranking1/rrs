package com.jyujyu.review.api;

import com.jyujyu.review.dto.CreateReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewApi {

    @PostMapping("/review")
    public String createReview(
            @RequestBody CreateReviewRequest request
    ) {
        return "This is createReview";
    }

    @DeleteMapping("/review/{reviewId}")
    public String deleteReview(
            @PathVariable Long reviewId
    ) {
        return "This is deleteReview";
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public String getReviewByRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is getReviewByRestaurant";
    }
}

package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateReviewRequest {
    private Long restaurantId;
    private String content;
    private double score;

    public CreateReviewRequest() {
    }

    @Builder
    public CreateReviewRequest(Long restaurantId, String content, double score) {
        this.restaurantId = restaurantId;
        this.content = content;
        this.score = score;
    }
}

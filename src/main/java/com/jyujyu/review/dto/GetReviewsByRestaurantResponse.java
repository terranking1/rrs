package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GetReviewsByRestaurantResponse {
    private double avgScore;
    private List<ReviewDto> reviews;
    private PageDto page;

    public GetReviewsByRestaurantResponse() {
    }

    @Builder
    public GetReviewsByRestaurantResponse(double avgScore, List<ReviewDto> reviews, Long offset, int limit) {
        this.avgScore = avgScore;
        this.reviews = reviews;
        page = PageDto.builder()
                .offset(offset)
                .limit(limit)
                .build();

    }


}

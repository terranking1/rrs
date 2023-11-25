package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Builder
@Getter
public class GetReviewsByRestaurantRequest {
    private static final int MAX_SIZE = 2000;

    private Long restaurantId;

    @Builder.Default
    private Integer size = 2;

    @Builder.Default
    private Integer page = 1;

    public Long getOffset() {
        return (long) (max(1, page) - 1) * min(size, MAX_SIZE);
    }
}

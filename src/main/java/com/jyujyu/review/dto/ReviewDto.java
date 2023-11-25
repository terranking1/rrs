package com.jyujyu.review.dto;

import com.jyujyu.review.model.Review;
import lombok.Getter;

@Getter
public class ReviewDto {

    private Long id;
    private String content;
    private double score;
    private String createdAt;

    public ReviewDto() {
    }

    public ReviewDto(Review review) {
        id = review.getId();
        content = review.getContent();
        score = review.getScore();
        createdAt = review.getCreated_at();
    }
}

package com.jyujyu.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PageDto {
    private Long offset;
    private int limit;

    public PageDto() {
    }

    @Builder
    public PageDto(Long offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }
}

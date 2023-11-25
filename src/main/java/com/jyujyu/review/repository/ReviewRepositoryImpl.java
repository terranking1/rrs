package com.jyujyu.review.repository;

import com.jyujyu.review.dto.GetReviewsByRestaurantRequest;
import com.jyujyu.review.dto.ReviewDto;
import com.jyujyu.review.model.QRestaurant;
import com.jyujyu.review.model.QReview;
import com.jyujyu.review.model.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public double getAvgScoreByRestaurant(Long restaurantId) {
        return queryFactory
                .select(QReview.review.score.avg())
                .from(QReview.review)
                .where(QReview.review.restaurant.id.eq(restaurantId))
                .fetchFirst();
    }

    @Override
    public List<Review> getReviewsByRestaurant(GetReviewsByRestaurantRequest request) {
        return queryFactory
                .selectFrom(QReview.review)
                .where(QRestaurant.restaurant.id.eq(request.getRestaurantId()))
                .offset(request.getOffset())
                .limit(request.getSize())
                .fetch();
    }
}

package com.jyujyu.review.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "review")
public class Review extends BaseTimeNotUpdateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @NotNull
    @Lob
    private String content;

    @NotNull
    private double score;

    public Review() {
    }

    @Builder
    public Review(Restaurant restaurant, String content, double score) {
        this.restaurant = restaurant;
        this.content = content;
        this.score = score;
    }
}

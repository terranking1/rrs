package com.jyujyu.review.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "restaurant_menu")
public class RestaurantMenu extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_menu_id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @NotNull
    private String name;

    @NotNull
    private int price;

    public RestaurantMenu() {
    }

    @Builder
    public RestaurantMenu(Restaurant restaurant, String name, int price) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
    }
}

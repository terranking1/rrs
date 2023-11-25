package com.jyujyu.review.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "restaurant")
public class Restaurant extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantMenu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @NotNull
    private String name;

    @NotNull
    private String address;

    public Restaurant() {
    }

    @Builder
    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void changeRestaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

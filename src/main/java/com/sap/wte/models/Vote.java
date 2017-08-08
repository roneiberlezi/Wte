package com.sap.wte.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by I863273 on 07/08/2017.
 */
@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private int id;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Poll getVoting() {
        return poll;
    }

    public void setVoting(Poll poll) {
        this.poll = poll;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

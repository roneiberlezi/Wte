package com.sap.wte.pojos;

import com.sap.wte.models.Restaurant;

import java.sql.Date;
import java.util.List;

/**
 * Created by I863273 on 14/08/2017.
 */
public class PollPojo {
    private int id;

    private Date date;

    private String title;

    private List<Restaurant> restaurants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}

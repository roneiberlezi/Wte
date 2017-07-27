package com.sap.wte.daos;

import com.sap.wte.models.Restaurant;

import java.util.List;

/**
 * Created by I863273 on 26/07/2017.
 */
public interface RestaurantDao {
    void insert(Restaurant restaurant);

    void update(Restaurant restaurant);

    List<Restaurant> listRestaurants();

    void delete(int id);

    Restaurant getRestaurant(int id);
}

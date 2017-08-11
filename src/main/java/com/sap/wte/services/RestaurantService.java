package com.sap.wte.services;

import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by I863273 on 26/07/2017.
 */
public interface RestaurantService {
    List<Restaurant> listRestaurants();

    List<Restaurant> listRestaurants(Poll poll);

    void createRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(int id);

    void updateRestaurant(Restaurant restaurant);

    void removeRestaurante(int id);
}

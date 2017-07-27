package com.sap.wte.services.imp;

import com.sap.wte.daos.RestaurantDao;
import com.sap.wte.models.Restaurant;
import com.sap.wte.services.RestaurantService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by I863273 on 26/07/2017.
 */
public class DefaultRestaurantService implements RestaurantService{

    @Resource
    RestaurantDao restaurantDao;

    @Override
    public List<Restaurant> listRestaurants() {
        return restaurantDao.listRestaurants();
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantDao.insert(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return restaurantDao.getRestaurant(id);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantDao.update(restaurant);
    }
}

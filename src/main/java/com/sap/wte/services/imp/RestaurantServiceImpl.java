package com.sap.wte.services.imp;

import com.sap.wte.comparators.RestaurantComparator;
import com.sap.wte.daos.RestaurantDao;
import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;
import com.sap.wte.services.RestaurantService;
import org.springframework.transaction.annotation.Transactional;
import com.sap.wte.comparators.RestaurantComparator;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * Created by I863273 on 26/07/2017.
 */
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

    @Resource
    RestaurantDao restaurantDao;

    @Override
    public List<Restaurant> listRestaurants() {
        return restaurantDao.listRestaurants();
    }

    @Override
    public List<Restaurant> listRestaurants(Poll poll) {
        List<Restaurant> list;
        list = restaurantDao.listRestaurants(poll);
        list.sort( new RestaurantComparator());
        return list;
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

    @Override
    public void removeRestaurante(int id) {
        restaurantDao.delete(id);
    }
}

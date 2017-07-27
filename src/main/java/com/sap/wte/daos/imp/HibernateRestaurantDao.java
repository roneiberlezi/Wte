package com.sap.wte.daos.imp;

import com.sap.wte.daos.RestaurantDao;
import com.sap.wte.models.Restaurant;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by I863273 on 26/07/2017.
 */
public class HibernateRestaurantDao extends HibernateDaoSupport implements RestaurantDao {

    @Transactional
    @Override
    public void insert(Restaurant restaurant) {
        getHibernateTemplate().save(restaurant);
    }

    @Transactional
    @Override
    public void update(Restaurant restaurant) {
        getHibernateTemplate().update(restaurant);
    }

    @Override
    public List<Restaurant> listRestaurants() {
        return (List<Restaurant>) getHibernateTemplate().find("from com.sap.wte.models.Restaurant");
    }

    @Transactional
    @Override
    public void delete(int id) {

    }

    @Override
    public Restaurant getRestaurant(int id) {
        return (Restaurant) getHibernateTemplate().get(Restaurant.class, id);
    }
}

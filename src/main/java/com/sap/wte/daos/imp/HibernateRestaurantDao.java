package com.sap.wte.daos.imp;

import com.sap.wte.daos.RestaurantDao;
import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by I863273 on 26/07/2017.
 */
public class HibernateRestaurantDao extends HibernateDaoSupport implements RestaurantDao {

    @Override
    public void insert(Restaurant restaurant) {
        getHibernateTemplate().save(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
        getHibernateTemplate().saveOrUpdate(restaurant);
    }

    @Override
    public List<Restaurant> listRestaurants() {
        return (List<Restaurant>) getHibernateTemplate().find("from com.sap.wte.models.Restaurant");
    }

    @Override
    public List<Restaurant> listRestaurants(Poll poll) {
        Session session = getSessionFactory().getCurrentSession();
        session.enableFilter("myPoll").setParameter("pollParam", poll.getId());

        return (List<Restaurant>) session.createQuery("select r from Restaurant r").list();
    }

    @Override
    public void delete(int id) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        getHibernateTemplate().delete(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return (Restaurant) getHibernateTemplate().get(Restaurant.class, id);
    }

    @Override
    public List<Restaurant> filter(String value) {

        try {
            FullTextSession fullTextSession = Search.getFullTextSession(getSessionFactory().getCurrentSession());
            Transaction tx = fullTextSession.getTransaction();

            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Restaurant.class)
                    .overridesForField("name", "customanalyzer_query")
                    .overridesForField("description", "customanalyzer_query")
                    .overridesForField("location", "customanalyzer_query")
                    .get();
            org.apache.lucene.search.Query query = qb
                    .keyword()
                    .onFields("name", "description", "location")
                    .matching(value)
                    .createQuery();

            // wrap Lucene query in a org.hibernate.Query
            org.hibernate.Query hibQuery =
                    fullTextSession.createFullTextQuery(query, Restaurant.class);

            // execute search
            List<Restaurant> result = (List<Restaurant>) hibQuery.list();

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

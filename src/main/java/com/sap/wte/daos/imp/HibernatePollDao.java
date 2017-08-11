package com.sap.wte.daos.imp;

import com.sap.wte.daos.PollDao;
import com.sap.wte.models.Poll;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.sql.Date;
import java.util.List;

/**
 * Created by I863273 on 08/08/2017.
 */
public class HibernatePollDao extends HibernateDaoSupport implements PollDao {
    @Override
    public void save(Poll poll) {
        getHibernateTemplate().save(poll);
    }

    @Override
    public Poll getCurrentPoll() {
        Poll result = (Poll) currentSession().createQuery(
                "select p from Poll p where p.id = (select max(id) from Poll)")
                .getSingleResult();

        return result;
    }

    @Override
    public Poll getPoll(Date date) {
        List<Poll> result = (List<Poll>) currentSession().createQuery(
                "select p from Poll p where p.date = :date")
                .setParameter("date", date)
                .list();

        if (result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }
}

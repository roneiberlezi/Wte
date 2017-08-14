package com.sap.wte.daos.imp;

import com.sap.wte.daos.PollDao;
import com.sap.wte.models.Poll;
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
    public void saveOrUpdate(Poll poll) {
        getHibernateTemplate().saveOrUpdate(poll);
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

    @Override
    public Poll getPoll(int id) {
        return getHibernateTemplate().get(Poll.class, id);
    }

    @Override
    public void closePolls() {
        currentSession().createQuery("update Poll set state = 'C'").executeUpdate();
    }

    @Override
    public List<Poll> listPolls() {
        return (List<Poll>) getHibernateTemplate().find("from Poll p order by p.date");
    }

    @Override
    public void closePollBeforeDate(Date date) {
//        currentSession().createQuery("");
    }

    @Override
    public Poll getPollBeforeDate(Date date) {
        List<Poll> result = (List<Poll>) currentSession().createQuery("select p from Poll p where p.date < :date order by date desc")
                .setParameter("date", date).list();

        if (result.size() > 0){
            return result.get(0);
        }else {
            return null;
        }
    }
}

package com.sap.wte.daos.imp;

import com.sap.wte.daos.VoteDao;
import com.sap.wte.models.Vote;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by I863273 on 09/08/2017.
 */
public class HibernateVoteDao extends HibernateDaoSupport implements VoteDao{
    @Override
    public void saveOrUpdate(Vote vote) {
        getHibernateTemplate().saveOrUpdate(vote);
    }

    @Override
    public Vote findVote(Vote vote) {
        List<Vote> result;
        Session session = getSessionFactory().getCurrentSession();
        result = (List<Vote>) session.createQuery("select v from Vote v where v.poll = :poll and v.user = :user")
                .setParameter("poll", vote.getPoll())
                .setParameter("user", vote.getUser()).list();

        if (!result.isEmpty()){
            return result.get(0);
        }else{
            return null;
        }
    }
}

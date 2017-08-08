package com.sap.wte.daos.imp;

import com.sap.wte.daos.PollDao;
import com.sap.wte.models.Poll;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by I863273 on 08/08/2017.
 */
public class HibernatePollDao extends HibernateDaoSupport implements PollDao {
    @Override
    public void save(Poll poll) {
        getHibernateTemplate().save(poll);
    }
}

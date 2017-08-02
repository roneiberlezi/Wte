package com.sap.wte.daos.imp;

import com.sap.wte.daos.UserDao;
import com.sap.wte.models.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by I863273 on 01/08/2017.
 */
public class HibernateUserDao extends HibernateDaoSupport implements UserDao {
    @Override
    public void save(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public User findByUserName(String name) {
        List<User> users;
        users = (List<User>) getHibernateTemplate().find("from com.sap.wte.models.User u where u.name = ?", name);
        if (!users.isEmpty()){
            return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public User findByUserEmail(String email) {
        List<User> users;
        users = (List<User>) getHibernateTemplate().find("from com.sap.wte.models.User u where u.email = ?", email);

        if (!users.isEmpty()){
            return users.get(0);
        }else{
            return null;
        }
    }
}

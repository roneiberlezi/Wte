package com.sap.wte.services.imp;

import com.sap.wte.daos.UserDao;
import com.sap.wte.models.User;
import com.sap.wte.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by I863273 on 01/08/2017.
 */
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findUserByUsername(String name) {
        return userDao.findByUserName(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByUserEmail(email);
    }
}

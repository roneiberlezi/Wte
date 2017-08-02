package com.sap.wte.daos;

import com.sap.wte.models.Restaurant;
import com.sap.wte.models.User;

import java.util.List;

/**
 * Created by I863273 on 01/08/2017.
 */
public interface UserDao {
    void save(User user);

    User findByUserName(String name);

    User findByUserEmail(String email);
}

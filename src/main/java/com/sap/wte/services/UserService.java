package com.sap.wte.services;

import com.sap.wte.models.User;

/**
 * Created by I863273 on 01/08/2017.
 */
public interface UserService {
    void save(User user);

    User findUserByUsername(String name);

    User findUserByEmail(String email);
}

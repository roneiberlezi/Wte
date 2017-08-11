package com.sap.wte.services;

import com.sap.wte.models.User;

/**
 * Created by I863273 on 02/08/2017.
 */
public interface SecurityService {
    boolean isLoggedIn();

    String getUserEmail();

    User getCurrentUser();
}

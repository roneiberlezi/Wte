package com.sap.wte.services.imp;

import com.sap.wte.models.User;
import com.sap.wte.services.SecurityService;
import com.sap.wte.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * Created by I863273 on 02/08/2017.
 */
public class SecurityServiceImpl implements SecurityService{

    @Resource
    SecurityService securityService;

    @Resource
    UserService userService;

    @Override
    public boolean isLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return true;
        }
        return false;
    }

    @Override
    public String getUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public User getCurrentUser() {
        return userService.findUserByEmail(securityService.getUserEmail());
    }
}

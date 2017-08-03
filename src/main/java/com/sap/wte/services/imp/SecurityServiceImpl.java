package com.sap.wte.services.imp;

import com.sap.wte.services.SecurityService;
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

    @Override
    public boolean isLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return true;
        }
        return false;
    }
}

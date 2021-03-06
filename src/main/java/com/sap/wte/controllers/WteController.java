package com.sap.wte.controllers;

import com.sap.wte.services.RestaurantService;
import com.sap.wte.services.SecurityService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;


/**
 * Created by I863273 on 24/07/2017.
 */

@Controller
@RequestMapping(value = "/")
public class WteController {

    @Resource
    SecurityService securityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "redirect:/user/login";
    }
}

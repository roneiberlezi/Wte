package com.sap.wte.controllers;

import com.sap.wte.services.RestaurantService;
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
    RestaurantService restaurantService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "redirect:restaurant/";
    }

    @RequestMapping(value = "/bs", method = RequestMethod.GET)
    public String boostrapTest(){
        return "bs-test";
    }
}

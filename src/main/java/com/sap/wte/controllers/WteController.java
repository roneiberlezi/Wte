package com.sap.wte.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by I863273 on 24/07/2017.
 */

@Controller
public class WteController {

    @RequestMapping(value = "/")
    public String welcome(){
        return "index";
    }
}

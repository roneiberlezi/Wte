package com.sap.wte.controllers;

import com.sap.wte.models.User;
import com.sap.wte.services.UserService;
import com.sap.wte.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by I863273 on 01/08/2017.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    Validator userValidator;

    @Resource
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());

        return "user/registration-form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@Valid User user, BindingResult bindingResult, Model model){
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/registration-form";
        }

        userService.save(user);

        return "redirect:/restaurant/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "user/login-form";
    }
}

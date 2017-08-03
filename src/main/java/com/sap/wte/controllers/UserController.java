package com.sap.wte.controllers;

import com.sap.wte.models.User;
import com.sap.wte.services.SecurityService;
import com.sap.wte.services.UserService;
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

    @Resource
    SecurityService securityService;

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

        return "redirect:/user/login?registered";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout, String registered){
        if (securityService.isLoggedIn()){
            return "redirect:/restaurant/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        if (registered != null)
            model.addAttribute("message", "You have been registered successfully.");

        return "user/login-form";
    }
}

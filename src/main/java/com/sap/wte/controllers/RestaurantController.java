package com.sap.wte.controllers;

import com.sap.wte.models.Restaurant;
import com.sap.wte.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by I863273 on 24/07/2017.
 */

@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantController {
    @Resource
    RestaurantService restaurantService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("restaurants", restaurantService.listRestaurants());
        return "restaurant/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newRestaurantForm(Model model){
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant/new";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@Valid Restaurant restaurant, BindingResult bindingResult,
                                   Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "restaurant/new";
        }
        restaurantService.createRestaurant(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRestaurantForm(@RequestParam("id") int id, Model model){
        model.addAttribute("restaurant", restaurantService.getRestaurant(id));
        return "restaurant/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid Restaurant restaurant, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "restaurant/edit";
        }

        restaurantService.updateRestaurant(restaurant);
        redirectAttributes.addAttribute("success", true);

        return "redirect:/";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") int id, Model model){
        restaurantService.removeRestaurante(id);
        return "redirect:/";
    }
}

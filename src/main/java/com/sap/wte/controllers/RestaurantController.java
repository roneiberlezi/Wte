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
        return "restaurant/restaurant-form";
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(@Valid Restaurant restaurant, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "restaurant/restaurant-form";
        }

        if (restaurant.getId() == 0) {
            restaurantService.createRestaurant(restaurant);
        }else{
            restaurantService.updateRestaurant(restaurant);
        }

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRestaurantForm(@RequestParam("id") int id, Model model){
        model.addAttribute("restaurant", restaurantService.getRestaurant(id));
        return "restaurant/restaurant-form";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") int id, Model model){
        restaurantService.removeRestaurante(id);
        return "redirect:/";
    }
}

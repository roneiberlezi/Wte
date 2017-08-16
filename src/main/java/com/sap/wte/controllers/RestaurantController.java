package com.sap.wte.controllers;

import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;
import com.sap.wte.models.User;
import com.sap.wte.models.Vote;
import com.sap.wte.pojos.PollPojo;
import com.sap.wte.services.PollService;
import com.sap.wte.services.RestaurantService;
import com.sap.wte.services.SecurityService;
import com.sap.wte.services.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by I863273 on 24/07/2017.
 */

@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantController {
    @Resource
    RestaurantService restaurantService;

    @Resource
    PollService pollService;

    @Resource
    SecurityService securityService;

    @Resource
    VoteService voteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model){
        Poll currentPoll = pollService.getCurrentPoll();
        User currentUser = securityService.getCurrentUser();
        Vote vote = voteService.findPreviousVote(currentUser, currentPoll);

        List<PollPojo> pollList = new ArrayList<PollPojo>();
        for (Poll p : pollService.listPolls()) {
            PollPojo pp = new PollPojo();
            pp.setId(p.getId());
            pp.setDate(p.getDate());
            pp.setTitle(p.getTitle());
            pp.setRestaurants(restaurantService.listRestaurants(p));
            pollList.add(pp);
        }


        model.addAttribute("polls", currentPoll);
        model.addAttribute("historyPolls", pollList);
        model.addAttribute("vote", vote);
        model.addAttribute("restaurants", restaurantService.listRestaurants(currentPoll));
        return "restaurant/list";
    }


    @RequestMapping(value = "/{pollId}", method = RequestMethod.GET)
    public String lisPastPoll(@PathVariable("pollId") int pollId, Model model){
        Poll pastPoll = pollService.getPoll(pollId);
        User currentUser = securityService.getCurrentUser();
        Vote vote = voteService.findPreviousVote(currentUser, pastPoll);

        List<PollPojo> pollList = new ArrayList<PollPojo>();
        for (Poll p : pollService.listPolls()) {
            PollPojo pp = new PollPojo();
            pp.setId(p.getId());
            pp.setDate(p.getDate());
            pp.setTitle(p.getTitle());
            pp.setRestaurants(restaurantService.listRestaurants(p));
            pollList.add(pp);
        }


        model.addAttribute("poll", pastPoll);
        model.addAttribute("historyPolls", pollList);
        model.addAttribute("vote", vote);
        model.addAttribute("restaurants", restaurantService.listRestaurants(pastPoll));
        return "restaurant/list";
    }


    @ResponseBody
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public List<Restaurant> filter(@RequestParam("filter") String filter){
        restaurantService.filterRestaurants(filter);

        return null;
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
            Restaurant r = restaurantService.getRestaurant(restaurant.getId());
            restaurant.setVotes(r.getVotes());
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

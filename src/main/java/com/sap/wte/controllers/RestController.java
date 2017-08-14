package com.sap.wte.controllers;

import com.sap.wte.models.Restaurant;
import com.sap.wte.services.PollService;
import com.sap.wte.services.RestaurantService;
import com.sap.wte.services.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by I863273 on 09/08/2017.
 */
@Controller
@RequestMapping(value = "/rest")
public class RestController {

    @Resource
    VoteService voteService;

    @Resource
    RestaurantService restaurantService;

    @Resource
    PollService pollService;

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    @ResponseBody
    public boolean vote(int restaurantId){
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        voteService.vote(restaurant);

        return true;
    }

    @RequestMapping(value = "/list-restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> listRestaurants(){
        return restaurantService.listRestaurants(pollService.getCurrentPoll());
    }

    @RequestMapping(value = "/list-restaurants/{pollId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> listRestaurants(@PathVariable("pollId") int pollId){
        return restaurantService.listRestaurants(pollService.getPoll(pollId));
    }
}

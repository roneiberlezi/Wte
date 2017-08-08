package com.sap.wte.controllers;

import com.sap.wte.models.Poll;
import com.sap.wte.pojos.PollForm;
import com.sap.wte.services.PollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Date;

/**
 * Created by I863273 on 08/08/2017.
 */
@Controller
@RequestMapping(value = "/poll")
public class PollRestController {

    @Resource
    PollService pollService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public boolean create(PollForm poll){
        pollService.create(poll);
        return true;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String pollForm(Model model){
        model.addAttribute("poll", new PollForm());
        return "poll/poll-modal";
    }

}

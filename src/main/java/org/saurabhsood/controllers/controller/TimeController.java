package org.saurabhsood.controllers.controller;

import org.apache.log4j.Logger;
import org.saurabhsood.controllers.service.TimeMagager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TimeController {
    static Logger log = Logger.getLogger(TimeController.class);

    @Autowired
    TimeMagager manager;

    @GetMapping(value = "/getAllTimes")
    public ModelAndView getAllTimes(Model model)
    {
        log.info("informational message");
        log.trace("detailed message");
        ModelAndView mav = new ModelAndView("timeListDisplay");
        model.addAttribute("timeList", manager.getAllTimes());
        mav.addObject(model);
        return mav;
    }

    @GetMapping(value = "/addTime")
    public String addTime(){
        log.debug("addTime function - add to postgres");
        return manager.insertTime();
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}



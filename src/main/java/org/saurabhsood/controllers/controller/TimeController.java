package org.saurabhsood.controllers.controller;

import org.apache.log4j.Logger;
import org.saurabhsood.controllers.service.TimeMagager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value = "/getTimeByID/{id}", method = GET)
    @ResponseBody
    public ModelAndView getTimeByID(Model model,  @PathVariable UUID id)
    {
        log.info("getTimeByID");
        ModelAndView mav = new ModelAndView("timeListDisplay");
        model.addAttribute("timeList", manager.findPersonsByFirstnameQueryDSL(id));
        mav.addObject(model);
        return mav;
    }

    @RequestMapping(value = "/getTimeByID2/{id}", method = GET)
    @ResponseBody
    public ModelAndView getTimeByID2(Model model,  @PathVariable UUID id)
    {
        log.info("getTimeByID");
        ModelAndView mav = new ModelAndView("timeListDisplay");
        model.addAttribute("timeList", manager.findPersonsByFirstnameQueryDSL2(id));
        mav.addObject(model);
        return mav;
    }

    @GetMapping(value = "/addTime")
    public String addTime(){
        log.debug("addTime function - add to postgres");
        return manager.insertTime();
    }

    @GetMapping("/403")
    public ModelAndView error403() {
        ModelAndView mav = new ModelAndView("error/403");
        return mav;
    }


}



package org.saurabhsood.controllers.controller;

import org.apache.log4j.Logger;
import org.saurabhsood.controllers.exception.CustomException;
import org.saurabhsood.controllers.service.SaleManager;
import org.saurabhsood.controllers.service.TimeMagager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class SaleController {
    static Logger log = Logger.getLogger(SaleController.class);

    @Autowired
    SaleManager manager;

    @GetMapping(value = "/getAllSale")
    public ModelAndView getAllSale(Model model)
    {
        log.info("saleListDisplay message");
        ModelAndView mav = new ModelAndView("saleListDisplay");
        model.addAttribute("saleList", manager.getAllSale());
        mav.addObject(model);
            return mav;
    }

    @RequestMapping(value = "/postAllSale", method = RequestMethod.GET, produces = "application/json")
    public String  postAllSale(@RequestParam("name") String name)
    {
        log.info("saleListDisplay message");
        return name;
    }
}

package org.saurabhsood.controllers.controller;

import org.apache.log4j.Logger;
import org.saurabhsood.controllers.exception.CustomException;
import org.saurabhsood.controllers.service.SaleManager;
import org.saurabhsood.controllers.service.TimeMagager;
import org.saurabhsood.controllers.uniquity.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class SaleController  extends GlobalControllerExceptionHandler{
    static Logger log = Logger.getLogger(SaleController.class);

    @Autowired
    SaleManager manager;

    @GetMapping(value = "/getAllSale")
    public ModelAndView getAllSale(Model model)
    {
        LogUtil.info(this.getClass(),"saleListDisplay message");
        ModelAndView mav = new ModelAndView("saleListDisplay");
        model.addAttribute("saleList", manager.getAllSale());
        mav.addObject(model);
            return mav;
    }

    @RequestMapping(value = "/postAllSale", method = RequestMethod.GET, produces = "application/json")
    public String  postAllSale(@RequestParam("name") String name)
    {
        LogUtil.info(this.getClass(),"saleListDisplay message");
        return name;
    }

    @GetMapping(value = "/addSale")
    public String addSale(){
        LogUtil.info(this.getClass(),"insertSale function - add to postgres");
        return manager.insertSale();
    }

    @RequestMapping(value = "/getSaleByID/{id}", method = GET)
    @ResponseBody
    public ModelAndView getTimeByID(Model model,  @PathVariable UUID id)
    {
        LogUtil.info(this.getClass(),"getSaleByID");
        ModelAndView mav = new ModelAndView("saleListDisplay");
        model.addAttribute("saleList", manager.findSaleByFirstnameQueryDSL(id));
        mav.addObject(model);
        return mav;
    }
}

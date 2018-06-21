package org.saurabhsood.controllers.controller;

import org.apache.log4j.Logger;
import org.saurabhsood.controllers.service.LocationManager;
import org.saurabhsood.controllers.service.ProductManager;
import org.saurabhsood.controllers.uniquity.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController extends GlobalControllerExceptionHandler{

    static Logger log = Logger.getLogger(LocationController.class);

    @Autowired
    LocationManager manager;


    @GetMapping(value = "/addLocation")
    public String addLocation(){
        LogUtil.info(this.getClass(),"addPaddLocationroduct function - add to postgres");
        return manager.insertSale();
    }
}

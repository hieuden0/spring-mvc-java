package org.saurabhsood.controllers.controller;


import org.apache.log4j.Logger;
import org.saurabhsood.controllers.service.ProductManager;
import org.saurabhsood.controllers.service.TimeMagager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends GlobalControllerExceptionHandler{

    static Logger log = Logger.getLogger(ProductController.class);

    @Autowired
    ProductManager manager;


    @GetMapping(value = "/addProduct")
    public String addProduct(){
        log.debug("addProduct function - add to postgres");
        return manager.insertSale();
    }
}

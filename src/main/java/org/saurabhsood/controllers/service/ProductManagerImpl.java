package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.ProductDAO;
import org.saurabhsood.controllers.dao.SaleDAO;
import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager{
    @Autowired
    ProductDAO dao;

    @Override
    public List<ProductVO> getAllSale() {
        return dao.getAllSale();
    }

    @Override
    public String insertSale() {
        return dao.insertSale();
    }
}

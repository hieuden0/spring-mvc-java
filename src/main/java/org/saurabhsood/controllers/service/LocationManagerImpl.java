package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.LocationDAO;
import org.saurabhsood.controllers.dao.SaleDAO;
import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationManagerImpl implements LocationManager{
    @Autowired
    LocationDAO dao;

    @Override
    public List<LocationVO> getAllSale() {
        return dao.getAllSale();
    }

    @Override
    public String insertSale() {
        return dao.insertSale();
    }
}

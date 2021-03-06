package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.SaleDAO;
import org.saurabhsood.controllers.dao.TimeDAO;
import org.saurabhsood.controllers.model.SaleVO;
import org.saurabhsood.controllers.model.sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SaleManagerImpl implements SaleManager {
    @Autowired
    SaleDAO dao;

    @Override
    public List<SaleVO> getAllSale() {
        return dao.getAllSale();
    }

    @Override
    public String insertSale() {
        return dao.insertSale();
    }

    @Override
    public List<sale> findSaleByFirstnameQueryDSL(UUID id) {
        return dao.findSaleByFirstnameQueryDSL(id);
    }
}

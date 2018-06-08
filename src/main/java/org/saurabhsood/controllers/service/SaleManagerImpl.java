package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.SaleDAO;
import org.saurabhsood.controllers.dao.TimeDAO;
import org.saurabhsood.controllers.model.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleManagerImpl implements SaleManager {
    @Autowired
    SaleDAO dao;

    @Override
    public List<SaleVO> getAllSale() {
        return dao.getAllSale();
    }
}

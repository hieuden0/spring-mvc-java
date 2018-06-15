package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.SaleDAO;
import org.saurabhsood.controllers.model.SaleVO;
import org.saurabhsood.controllers.model.sale;

import java.util.List;
import java.util.UUID;

public interface SaleManager {
    public List<SaleVO> getAllSale();

    public String insertSale();

    public List<sale> findSaleByFirstnameQueryDSL(UUID id);
}

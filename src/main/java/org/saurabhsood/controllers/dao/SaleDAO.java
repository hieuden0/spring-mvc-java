package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.SaleVO;
import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.model.sale;
import org.saurabhsood.controllers.model.time;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface SaleDAO {
    public List<SaleVO> getAllSale();

    public String insertSale();

    public List<sale> findSaleByFirstnameQueryDSL(UUID id);
}

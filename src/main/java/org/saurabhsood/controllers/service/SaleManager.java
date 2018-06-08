package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.SaleDAO;
import org.saurabhsood.controllers.model.SaleVO;

import java.util.List;

public interface SaleManager {
    public List<SaleVO> getAllSale();
}

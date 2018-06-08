package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.SaleVO;
import org.saurabhsood.controllers.model.TimeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SaleDAO {
    public List<SaleVO> getAllSale();
}

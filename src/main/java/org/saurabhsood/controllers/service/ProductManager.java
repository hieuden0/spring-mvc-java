package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.model.ProductVO;
import org.saurabhsood.controllers.model.SaleVO;

import java.util.List;

public interface ProductManager {
    public List<ProductVO> getAllSale();

    public String insertSale();
}

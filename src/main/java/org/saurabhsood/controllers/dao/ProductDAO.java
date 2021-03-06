package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.ProductVO;
import org.saurabhsood.controllers.model.SaleVO;

import java.util.List;
import java.util.UUID;

public interface ProductDAO {
    public List<ProductVO> getAllSale();

    public String insertSale();

    public ProductVO getProductByID(UUID id);
}

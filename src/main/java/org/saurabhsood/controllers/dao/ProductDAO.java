package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.ProductVO;

import java.util.UUID;

public interface ProductDAO {

    public ProductVO getProductByID(UUID id);
}

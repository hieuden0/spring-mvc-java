package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.SaleVO;

import java.util.List;
import java.util.UUID;

public interface LocationDAO {
    public List<LocationVO> getAllSale();

    public String insertSale();

    public LocationVO getLocationByID(UUID id);
}

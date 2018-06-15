package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.model.LocationVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LocationManager {
    public List<LocationVO> getAllSale();

    public String insertSale();
}

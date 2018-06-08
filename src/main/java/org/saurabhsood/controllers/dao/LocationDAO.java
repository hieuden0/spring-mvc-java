package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.LocationVO;

import java.util.UUID;

public interface LocationDAO {
    public LocationVO getLocationByID(UUID id);
}

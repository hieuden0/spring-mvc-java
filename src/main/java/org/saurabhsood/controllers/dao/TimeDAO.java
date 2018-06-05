package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.TimeVO;

import java.util.List;

public interface TimeDAO {
    public List<TimeVO> getAllTime();

    public String insertTime();
}

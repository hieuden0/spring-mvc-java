package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.model.TimeVO;

import java.util.List;

public interface TimeMagager
{
    public List<TimeVO> getAllTimes();

    public String insertTime();
}

package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.model.time;

import java.util.List;
import java.util.UUID;

public interface TimeMagager
{
    public List<TimeVO> getAllTimes();

    public String insertTime();

    public List<time> findPersonsByFirstnameQueryDSL(UUID id);

    public List<time> findPersonsByFirstnameQueryDSL2(UUID id);
}

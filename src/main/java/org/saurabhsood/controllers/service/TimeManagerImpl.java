package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.TimeDAO;
import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.model.time;
import org.saurabhsood.controllers.uniquity.PostgresDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TimeManagerImpl implements TimeMagager {
    @Autowired
    TimeDAO dao;

    @Override
    public List<TimeVO> getAllTimes() {
        return dao.getAllTime();
    }

    @Override
    public String insertTime() {
        return dao.insertTime();
    }

    @Override
    public List<time> findPersonsByFirstnameQueryDSL(UUID id) {
        return dao.findPersonsByFirstnameQueryDSL(id);
    }

    @Override
    public List<time> findPersonsByFirstnameQueryDSL2(UUID id) {
        return dao.findPersonsByFirstnameQueryDSL2(id);
    }
}

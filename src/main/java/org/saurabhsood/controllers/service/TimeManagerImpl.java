package org.saurabhsood.controllers.service;

import org.saurabhsood.controllers.dao.TimeDAO;
import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.uniquity.PostgresDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

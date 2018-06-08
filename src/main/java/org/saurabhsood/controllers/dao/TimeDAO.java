package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.TimeVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TimeDAO  {
    public List<TimeVO> getAllTime();

    public TimeVO getTimeByID(UUID id);

    public String insertTime();
}

package org.saurabhsood.controllers.controller;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.saurabhsood.controllers.dao.TimeDAO;
import org.saurabhsood.controllers.dao.TimeDAOImpl;
import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.model.time;
import org.saurabhsood.controllers.service.TimeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
public class TimeControllerTest {

    MockMvc mockMvc;

    @Mock
    TimeController timeController;

    @Mock
    TimeManagerImpl dao;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(timeController).build();
    }

    @Test
    public void getAllTimes() throws Exception {
        List<TimeVO> questions = new ArrayList<TimeVO>();
        questions.add( new TimeVO(UUID.randomUUID(),new Date(),new Date(),1,2,3));
        when(dao.getAllTimes()).thenReturn( questions );

        TimeController controller = new TimeController();

        ReflectionTestUtils.setField( controller, "manager", dao );
        // call the method under test
        ModelAndView mav = controller.getAllTimes();

        // review the results.
        assertEquals( questions, mav.getModel().get( "timeList" ));
        assertEquals( "timeListDisplay", mav.getViewName());
    }
    @Test
    public void getTimeByID() throws Exception {
        List<time> questions = new ArrayList<time>();
        questions.add(new time(UUID.randomUUID(),new Date(),new Date(),1,2,3));
        when(dao.findPersonsByFirstnameQueryDSL2(UUID.fromString("ffffffff-d857-4e90-b1e5-df98a3d40cd6"))).thenReturn( questions );

        TimeController controller = new TimeController();

        ReflectionTestUtils.setField( controller, "manager", dao );
        // call the method under test
        ModelAndView mav = controller.getTimeByID((UUID.fromString("ffffffff-d857-4e90-b1e5-df98a3d40cd6")));

        // review the results.
        assertEquals( questions, mav.getModel().get( "timeList" ));
        assertEquals( "timeListDisplay", mav.getViewName());
    }

}
package org.saurabhsood.controllers.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.model.UserVO;
import org.saurabhsood.controllers.uniquity.PostgresDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class TimeDAOImpl implements TimeDAO {

    @Autowired
    private CassandraOperations cassandraOperations;

    public List<TimeVO> getAllTime()
    {
        String query = "select * from time";
//        //Creating Cluster object
//        Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
//        //Creating Session object
//        Session session = cluster.connect("hieubui");
//        //Getting the ResultSet
//        ResultSet result = session.execute(query);
//        Iterator<Row> iter = result.iterator();
//        List<TimeVO> listTime = new ArrayList<>();
//        iter.forEachRemaining(row ->
//                listTime.add(new TimeVO(row.getUUID("TIME_ID"),row.getInt("MONTH"),row.getInt("QUARTER"),row.getInt("YEAR")))
//        );
        List<TimeVO> listTime = new ArrayList<>();
        List<TimeVO> results = cassandraOperations.select(query, TimeVO.class );
        for (TimeVO p : results) {
            listTime.add(p);
        }

        return listTime;
    }

    public TimeVO getTimeByID(UUID id)
    {
        String query = "Select * "//
                + " from time where time_id = " + id + " ALLOW FILTERING";

        TimeVO result = cassandraOperations.selectOne(query, TimeVO.class );
        return result;
    }

    @Override
    public String insertTime() {
        try {
            PostgresDatabase db = new PostgresDatabase();
            db.connect();
            List<TimeVO> listTime = getAllTime();
            for (int i = 0; i < listTime.size(); i++) {
                TimeVO item = listTime.get(i);
                db.createItem(item);
            }
            return "1";
        }catch (Exception e){
            return "";
        }
    }
}

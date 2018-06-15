package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.uniquity.PostgresDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LocationDAOImpl implements LocationDAO{

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public List<LocationVO> getAllSale() {
        String query = "select * from location";
        List<LocationVO> listTime = new ArrayList<>();
        List<LocationVO> results = cassandraOperations.select(query, LocationVO.class );
        for (LocationVO p : results) {
            listTime.add(p);
        }
        return results;
    }

    @Override
    public String insertSale() {
        try {
            PostgresDatabase db = new PostgresDatabase();
            db.connect();
            List<LocationVO> listTime = getAllSale();
            for (int i = 0; i < listTime.size(); i++) {
                LocationVO item = listTime.get(i);
                db.createSaleItem(item);
            }
            return "1";
        }catch (Exception e){
            return "";
        }
    }

    @Override
    public LocationVO getLocationByID(UUID id) {
        String query = "Select * "//
                + " from location where location_id = " + id + " ALLOW FILTERING";
        LocationVO result = cassandraOperations.selectOne(query, LocationVO.class );

        return result;
    }
}

package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.TimeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class LocationDAOImpl implements LocationDAO{

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public LocationVO getLocationByID(UUID id) {
        String query = "Select * "//
                + " from location where location_id = " + id + " ALLOW FILTERING";
        LocationVO result = cassandraOperations.selectOne(query, LocationVO.class );

        return result;
    }
}

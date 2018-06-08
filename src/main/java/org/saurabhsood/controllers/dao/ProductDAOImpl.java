package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public ProductVO getProductByID(UUID id) {
        String query = "Select * "//
                + " from product where product_id = " + id + " ALLOW FILTERING";
        ProductVO result = cassandraOperations.selectOne(query, ProductVO.class);

        return result;
    }


}

package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.ProductVO;
import org.saurabhsood.controllers.uniquity.PostgresDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public List<ProductVO> getAllSale() {
        String query = "select * from product";
        List<ProductVO> listTime = new ArrayList<>();
        List<ProductVO> results = cassandraOperations.select(query, ProductVO.class );
        for (ProductVO p : results) {
            listTime.add(p);
        }
        return results;
    }

    @Override
    public String insertSale() {
        try {
            PostgresDatabase db = new PostgresDatabase();
            db.connect();
            List<ProductVO> listTime = getAllSale();
            for (int i = 0; i < listTime.size(); i++) {
                ProductVO item = listTime.get(i);
                db.createSaleItem(item);
            }
            return "1";
        }catch (Exception e){
            return "";
        }
    }

    @Override
    public ProductVO getProductByID(UUID id) {
        String query = "Select * "//
                + " from product where product_id = " + id + " ALLOW FILTERING";
        ProductVO result = cassandraOperations.selectOne(query, ProductVO.class);

        return result;
    }


}

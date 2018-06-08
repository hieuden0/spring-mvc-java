package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.SaleVO;
import org.saurabhsood.controllers.model.TimeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleDAOImpl implements SaleDAO{

    @Autowired
    private CassandraOperations cassandraOperations;

    @Autowired
    private TimeDAO timeDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public List<SaleVO> getAllSale() {
        try {
            String query = "select * from sale";
            List<SaleVO> listTime = new ArrayList<>();
            List<SaleVO> results = cassandraOperations.select(query, SaleVO.class );
            for (SaleVO p : results) {
                p.setTimeVO(timeDAO.getTimeByID(p.getTime_id()));
                p.setLocationVO(locationDAO.getLocationByID(p.getLocation_id()));
                p.setProductVO(productDAO.getProductByID(p.getProduct_id()));
                listTime.add(p);
            }

            return  listTime;

        }catch (Exception e){
            return null;
        }
    }
}

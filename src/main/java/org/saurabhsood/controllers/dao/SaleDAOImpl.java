package org.saurabhsood.controllers.dao;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.saurabhsood.controllers.model.*;
import org.saurabhsood.controllers.uniquity.PostgresDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                p.setTime(timeDAO.getTimeByID(p.getTime_id()));
                p.setLocation(locationDAO.getLocationByID(p.getLocation_id()));
                p.setProduct(productDAO.getProductByID(p.getProduct_id()));
                listTime.add(p);
            }

            return  listTime;

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String insertSale() {
        try {
            PostgresDatabase db = new PostgresDatabase();
            List<SaleVO> listTime = getAllSale();
            for (int i = 0; i < listTime.size(); i++) {
                SaleVO item = listTime.get(i);
                db.createSaleItem(item);
            }
            return "1";
        }catch (Exception e){
            return "";
        }
    }

    @Override
    public List<sale> findSaleByFirstnameQueryDSL(UUID id) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("persistencePostgre");
        EntityManager em = emf.createEntityManager();

        final JPAQuery<sale> query = new JPAQuery<>(em);
        final Qsale saleVO = new Qsale("sale");
        final Qtime time = new Qtime("time");
        final Qproduct product = new Qproduct("product");
        final Qlocation location = new Qlocation("location");

        List<sale> result =  query.from(saleVO).innerJoin(saleVO.location, location)
                .innerJoin(saleVO.product,product)
                .innerJoin(saleVO.time, time)
                .where(saleVO.sale_id.eq(id)).fetch();
        return  result;
    }
}

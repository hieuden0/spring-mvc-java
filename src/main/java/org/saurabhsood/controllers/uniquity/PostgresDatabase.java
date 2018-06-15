package org.saurabhsood.controllers.uniquity;

import org.postgresql.util.PGobject;
import org.saurabhsood.controllers.model.LocationVO;
import org.saurabhsood.controllers.model.ProductVO;
import org.saurabhsood.controllers.model.SaleVO;
import org.saurabhsood.controllers.model.TimeVO;

import java.sql.*;

public class PostgresDatabase {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1";

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public String createItem( TimeVO timeVO) {
        try {
            Connection conn = connect();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO hieubui.time (TIME_ID,CREATE_AT, MONTH, QUARTER, YEAR) VALUES (?, ?, ?, ?, ?)"
            );
            PGobject time_id = new PGobject();
            time_id.setType("uuid");
            time_id.setValue(timeVO.getTime_id().toString());
            st.setObject(1, time_id);
            st.setObject(2, Date.valueOf(java.time.LocalDate.now()));
            st.setInt(3, timeVO.getMONTH());
            st.setInt(4, timeVO.getQUARTER());
            st.setInt(5, timeVO.getYEAR());
            st.executeUpdate();
            st.close();
            return "1";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }


    public void createSaleItem(Object model) throws SQLException {
        Connection conn = connect();
        if (model instanceof SaleVO) {
            setSale(connect(), model);
        }

        if (model instanceof ProductVO) {
            setProduct(connect(), model);
        }

        if (model instanceof LocationVO) {
            setLocation(connect(), model);
        }
    }

    public void setSale(Connection conn, Object saleVOtemp) throws SQLException {
        SaleVO saleVO = (SaleVO)saleVOtemp;
        PreparedStatement st = conn.prepareStatement(
                "INSERT INTO hieubui.sale (sale_id,DOLLARS,location_id,product_id,time_id,MODIFIED_AT, CREATE_AT) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );
        PGobject sale_id = new PGobject();
        sale_id.setType("uuid");
        sale_id.setValue(saleVO.getSale_id().toString());
        st.setObject(1, sale_id);
        st.setString(2, saleVO.getDOLLARS());
        sale_id.setValue(saleVO.getLocation_id().toString());
        st.setObject(3, sale_id);
        sale_id.setValue(saleVO.getProduct_id().toString());
        st.setObject(4, sale_id);
        sale_id.setValue(saleVO.getTime_id().toString());
        st.setObject(5, sale_id);
        st.setObject(6, Date.valueOf(java.time.LocalDate.now()));
        st.setObject(7, Date.valueOf(java.time.LocalDate.now()));
        st.executeUpdate();
        st.close();
    }

    public void setLocation(Connection conn, Object saleVOtemp) throws SQLException {
        LocationVO saleVO = (LocationVO)saleVOtemp;
        PreparedStatement st = conn.prepareStatement(
                "INSERT INTO hieubui.location (location_id,city,country,modified_at, create_at) " +
                        "VALUES (?, ?, ?, ?, ?)"
        );
        PGobject sale_id = new PGobject();
        sale_id.setType("uuid");
        sale_id.setValue(saleVO.getLocation_id().toString());
        st.setObject(1, sale_id);
        st.setString(2, saleVO.getCITY());
        st.setObject(3, saleVO.getCOUNTRY());
        st.setObject(4, Date.valueOf(java.time.LocalDate.now()));
        st.setObject(5, Date.valueOf(java.time.LocalDate.now()));
        st.executeUpdate();
        st.close();
    }

    public void setProduct(Connection conn, Object saleVOtemp) throws SQLException {
        ProductVO saleVO = (ProductVO)saleVOtemp;
        PreparedStatement st = conn.prepareStatement(
                "INSERT INTO hieubui.product (product_id,class,inventory,item,modified_at, create_at) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
        );
        PGobject sale_id = new PGobject();
        sale_id.setType("uuid");
        sale_id.setValue(saleVO.getProduct_id().toString());
        st.setObject(1, sale_id);
        st.setString(2, saleVO.getCLASS());
        st.setString(3, saleVO.getINVENTORY());
        st.setInt(4, saleVO.getITEM());
        st.setObject(5, Date.valueOf(java.time.LocalDate.now()));
        st.setObject(6, Date.valueOf(java.time.LocalDate.now()));
        st.executeUpdate();
        st.close();
    }

}

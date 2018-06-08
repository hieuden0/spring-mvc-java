package org.saurabhsood.controllers.uniquity;

import org.postgresql.util.PGobject;
import org.saurabhsood.controllers.model.TimeVO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

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
            time_id.setValue(timeVO.getTIME_ID().toString());
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

}

package org.saurabhsood.controllers.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserVOMapper implements RowMapper<UserVO> {

    @Override
    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {

        String userName = rs.getString("USERNAME");
        String password = rs.getString("PASSWORD");

        return new UserVO(userName, password);
    }

}

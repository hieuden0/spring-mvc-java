package org.saurabhsood.controllers.model;

import org.springframework.data.cassandra.core.mapping.Column;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserVO {

    @Column(value = "USERNAME")
    private String userName;

    @Column(value = "PASSWORD")
    private String password;

    public UserVO()  {

    }

    public UserVO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

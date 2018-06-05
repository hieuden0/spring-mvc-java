package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.UserVO;

import java.util.List;

public interface UserInfoDAO {
    public UserVO findUserInfo(String userName);

    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
}

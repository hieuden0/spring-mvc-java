package org.saurabhsood.controllers.dao;

import org.saurabhsood.controllers.model.TimeVO;
import org.saurabhsood.controllers.model.UserVO;
import org.saurabhsood.controllers.model.UserVOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    private CassandraOperations cassandraOperations;


    @Override
    public UserVO findUserInfo(String userName) {
        String query = "Select * "//
                + " from user where \"USERNAME\" = '" + userName + "' ALLOW FILTERING";

        UserVO userInfo = cassandraOperations.selectOne(query, UserVO.class );
        return userInfo;

    }


    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select \"USER_ROLE\" "//
                + " from user_role where \"USERNAME\"  = '" + userName + "' ALLOW FILTERING";


        List<String> roles =cassandraOperations.select(sql, String.class);

        return roles;
    }
}

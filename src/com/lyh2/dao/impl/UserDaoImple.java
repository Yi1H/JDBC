package com.lyh2.dao.impl;

import com.lyh2.dao.IUserDao;
import com.lyh2.domain.User;
import com.lyh2.handle.BeanListHandle;
import com.lyh2.util.CUDRTemplate;
import java.util.List;

public class UserDaoImple implements IUserDao {

    @Override
    public void save(User user) {
        String sql = "insert into user(user,pwd) values(?,?)";
        CUDRTemplate.dml(sql,user.getUser(),user.getPwd());
    }

    @Override
    public List<User> getAll() {
            String sql = "Select * from user ";
            return CUDRTemplate.dql(sql,new BeanListHandle<>(User.class));
    }
}
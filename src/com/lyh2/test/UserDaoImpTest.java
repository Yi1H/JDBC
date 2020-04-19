package com.lyh2.test;

import com.lyh2.dao.impl.UserDaoImple;
import com.lyh2.domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoImpTest {
    @Test
    public void save(){
        User user = new User();
        user.setUser("ls");
        user.setPwd("456789");
        UserDaoImple udi = new UserDaoImple();
        udi.save(user);
    }
    @Test
    public void getAll(){
        UserDaoImple udi = new UserDaoImple();
        List<User> all = udi.getAll();
        System.out.println(all);
    }
}

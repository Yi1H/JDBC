package com.lyh2.dao;

import com.lyh2.domain.User;

import java.util.List;

public interface IUserDao {
    void save(User user);
    List<User> getAll();
}

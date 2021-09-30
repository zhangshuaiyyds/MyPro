package com.isoft.servlet.dao;

import com.isoft.servlet.entity.Emp;
import com.isoft.servlet.entity.User;

public interface UserDao {
    User login(String username,String password);
}

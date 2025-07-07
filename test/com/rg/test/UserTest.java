package com.rg.test;

import com.rg.dao.UserDao;
import com.rg.dao.impl.UserDaoImpl;
import com.rg.entity.User;
import org.junit.Test;

public class UserTest {
    @Test
    public void testGetUser() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUser("root", "admin");

        System.out.println(user);
    }
}

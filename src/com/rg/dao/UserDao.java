package com.rg.dao;

import com.rg.entity.User;
import com.rg.vo.CartVO;

import java.util.List;

public interface UserDao {
    User getUser(String username, String password);

    int add(String username, String password);

    User getUser(String username);
}

package com.example.demo.dao;

import com.example.demo.entity.Perms;
import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User findByUserName(String username);
    //根据用户名查询所有角色
    User findRolesByUserName(String username);
    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);
}

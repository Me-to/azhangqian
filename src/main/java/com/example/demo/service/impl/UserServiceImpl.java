package com.example.demo.service.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.Perms;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void register(User user) {
        String salt = SaltUtils.getSalt(new Random().nextInt(5) + 5);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
       userDao.save(user);

    }


    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }


    public List<Perms> findPermsByRoleId(String id) {
        return userDao.findPermsByRoleId(id);
    }


    public User findRolesByUserName(String username) {
        return userDao.findRolesByUserName(username);
    }
}

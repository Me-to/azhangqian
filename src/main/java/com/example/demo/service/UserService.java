package com.example.demo.service;

import com.example.demo.entity.Perms;
import com.example.demo.entity.User;
import com.example.demo.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.List;


public interface UserService {
     void register(User user);



     User findByUserName(String username);

     List<Perms> findPermsByRoleId(String id);


     User findRolesByUserName(String username);
}

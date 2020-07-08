package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User  {
    private String  id;
    private String username;
    private String password;
    private String salt;

    //定义角色集合
    private List<Role> roles;
}

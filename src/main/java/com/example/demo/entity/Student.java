package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author 张前
 * @since 2020-06-30 20:23:24
 */
@Data
public class Student implements Serializable {
   private static final long serialVersionUID = -26963879838237611L;
    
    private Integer id;
    
    private String number;
    
    private String name;
    
    private String sex;
    
    private Integer age;


}
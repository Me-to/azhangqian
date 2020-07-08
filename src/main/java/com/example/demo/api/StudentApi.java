package com.example.demo.api;

import com.example.demo.VO.ResultVO;
import com.example.demo.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(value = "Student数据接口",tags = {"操作"})
public interface StudentApi {
    @ApiOperation("添加student")
    ResultVO<String> insertStudent(@RequestBody Student student);
    @ApiOperation("查询所有student")
    ResultVO<List> findAllStudent();
    @ApiOperation("根据id删除student")
    ResultVO<String> deleteStudent(Integer id);
    @ApiOperation("根据id更新student")
    ResultVO<String> updateStudent(@RequestBody Student student);
    @ApiOperation("根据id查询student")
    ResultVO<Student> queryById(Integer id);
}

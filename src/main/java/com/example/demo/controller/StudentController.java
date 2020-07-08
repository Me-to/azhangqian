package com.example.demo.controller;


import com.example.demo.VO.ResultVO;
import com.example.demo.api.StudentApi;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表控制层
 *
 * @author 张前
 * @since 2020-06-30 20:23:24
 */
@RestController
@Api(value = "StudentController",tags = {"用户操作接口"})
@RequestMapping("student")
public class StudentController implements StudentApi {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @GetMapping("findById/{id}")
    public ResultVO<Student> queryById(@PathVariable("id")Integer id){
        if (studentService.queryById(id)==null){
            return  ResultVOUtil.error(107,"查询为空");
        }
        return ResultVOUtil.success(studentService.queryById(id));
    }

    /**
     * 查询所有用户
     * @return list集合
     */
    @GetMapping("students")
    public ResultVO<List> findAllStudent(){
        if (studentService.findAll()==null){
            return  ResultVOUtil.error(107,"查询为空");
        }
        List<Student> findAll=studentService.findAll();
        return  ResultVOUtil.success(findAll);
    }



    /**
     * 添加student
     * @param student
     * @return
     */
    @PostMapping("students")
    public ResultVO<String> insertStudent(@RequestBody Student student){
        int count=studentService.insert(student);
        if (count<=0){
            return ResultVOUtil.error(107,"添加失败");
        }
        return ResultVOUtil.success("添加成功",count);
    }

    /**
     * 修改student
     * @param student
     * @return
     */
    @PutMapping("students")
    public ResultVO<String> updateStudent(@RequestBody Student student){
        int count=studentService.update(student);
        if (count<=0){
            return ResultVOUtil.error(107,"修改失败");
        }
        return ResultVOUtil.success("修改成功",count);
    }

    /**
     * 根据主键删除student
     * @param id
     * @return
     */
    @DeleteMapping("students/{id}")
    public ResultVO<String> deleteStudent(@PathVariable("id") Integer id){
        int count=studentService.deleteById(id);
        if (count<=0){
            return ResultVOUtil.error(107,"删除失败");
        }
        return ResultVOUtil.success("删除成功",count);
    }

}
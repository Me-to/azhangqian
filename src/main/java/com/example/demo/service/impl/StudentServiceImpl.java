package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author 张前
 * @since 2020-06-30 20:23:24
 */
@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Transactional(readOnly = true)
    @Override
    public Student queryById(Integer id) {
        String key = "student_" + id;
        boolean hasKey = redisUtil.hasKey(key);
        if (hasKey) {
            String str = (String) redisUtil.get(key);
            Student student = new Gson().fromJson(str, Student.class);
            log.info("读取了了redis的数据");
            return student;
        }
        Student student = studentDao.queryById(id);
        String str = new Gson().toJson(student);
        redisUtil.set(key, str,60);
        log.info("读取了了mysql的数据");
        return student;

    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
//    @Transactional(readOnly = true)
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        String key = "student_a";
        boolean b = redisUtil.hasKey(key);
        if (b) {
            String o = (String) redisUtil.get(key);
            Type type = new TypeToken<List<Student>>() {
            }.getType();
            List<Student> list = new Gson().fromJson(o, type);
            log.info("读取了了redis的数据");
            return list;
        }
        List<Student> list = studentDao.queryAllByLimit(offset, limit);
        String toJson = new Gson().toJson(list);
        redisUtil.set(key, toJson,60);
        log.info("读取了了mysql的数据");

        return list;
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Student student) {
        String key = "student_" + student.getId();
        int count = studentDao.insert(student);
        if (count > 0) {
            Student student1 = studentDao.queryById(student.getId());
            String s = new Gson().toJson(student1);
            redisUtil.set(key, s, 60);
            log.info("存储了redis的数据");
        }
        return 0;

    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Student student) {
        String key = "student_" + student.getId();
        boolean hasKey = redisUtil.hasKey(key);
        int update = studentDao.update(student);
        Student query = studentDao.queryById(student.getId());
        if (update > 0) {
            if (hasKey) {
                String toJson = new Gson().toJson(query);
                redisUtil.del(key);
                redisUtil.set(key, toJson, 60);
                log.info("修改了redis的数据");
            }
        }

        return update;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        String key = "student_" + id;
        boolean hasKey = redisUtil.hasKey(key);
        int count = studentDao.deleteById(id);

        if (count > 0) {
            if (hasKey) {
                redisUtil.del(key);
                log.info("删除了redis的数据");
            }
        }
        return 0;
    }

    @Override
    public Student updatefind(Integer id) {

        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAll() {
        String key = "studentAll";
        boolean hasKey = redisUtil.hasKey(key);
        if (hasKey) {
            String o = (String) redisUtil.get(key);
            Type type = new TypeToken<List<Student>>() {
            }.getType();
            List<Student> list = new Gson().fromJson(o, type);
            log.info("读取了redis数据");
            return list;
        }
        List<Student> studentList = studentDao.findAll();
        String s = new Gson().toJson(studentList);
        redisUtil.set(key, s,60);
        log.info("读取了mysql数据");
        return studentList;
    }
}
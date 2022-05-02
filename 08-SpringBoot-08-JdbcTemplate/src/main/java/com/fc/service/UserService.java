package com.fc.service;

import com.fc.entity.User;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface UserService {
    //查询全部
    List<User> findAll();
    //查询单个
    User findById(Integer id);
    //查询全部
    Integer findCount();
    //添加学生
    int insert(User user);
    //修改学生
    int update(User user);
    //删除
    int delete(Integer id);
}

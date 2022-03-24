package com.fc.controller;

import com.fc.controller.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements  Studentdao{
//查询运行器
QueryRunner queryRunner = new QueryRunner();

    Connection connection = DruidUtil.getConnection();
//获取大
    @Override
    public int getTotalCout() {
      String sql = "select*from  student";
        List<Student> list =null;
        try {
          list = (List<Student>) queryRunner.query(connection,sql,new BeanHandler<>(Student.class));

if (list!=null){
    return  list.size();
}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return 0;
    }



    @Override
    public List<Student> getList(int pageNo, int pageSize) {
       String sql ="select  *from student limit ?,?";
       int start = (pageNo-1)*pageSize;
        List<Student> list =null;
        try {
           list = (List<Student>) queryRunner.query(connection,sql,new BeanHandler<>(Student.class),pageNo,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }
}

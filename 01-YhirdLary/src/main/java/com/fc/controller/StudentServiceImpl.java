package com.fc.controller;

import java.util.List;

public class StudentServiceImpl implements  StudentService{
 //业务逻辑层依赖

    Studentdao studentDao =new StudentDaoImpl();
    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
int totalCout=studentDao.getTotalCout();
List<Student> list = studentDao.getList(pageNo,pageSize);
        PageInfo<Student> pageInfo = new PageInfo<>(totalCout,pageSize,pageNo,list);

        return pageInfo;
    }
}

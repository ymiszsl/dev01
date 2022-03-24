package com.fc.controller;
//业务接口
public interface StudentService {


    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}

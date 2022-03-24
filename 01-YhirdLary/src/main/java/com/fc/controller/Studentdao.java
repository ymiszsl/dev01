package com.fc.controller;

import java.util.List;

public interface Studentdao {
    int getTotalCout();



    List<Student> getList(int pageNo, int pageSize);
}

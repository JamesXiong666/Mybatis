package com.james.dao;

import com.james.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询所有数据
    List<Student> selectStudents();
}
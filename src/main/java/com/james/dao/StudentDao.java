package com.james.dao;

import com.james.domain.PrimaryStudent;
import com.james.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询所有数据
    List<Student> selectStudents();

    //insert
    int insertStudent(Student student);

    //update
    int updateStudent(Student student);

    //delete
    int deleteStudent(int id);


}

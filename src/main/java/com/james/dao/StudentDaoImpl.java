package com.james.dao;

import com.james.common.MyBatisUtil;
import com.james.domain.PrimaryStudent;
import com.james.domain.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    // 实现接口中select方法
    public List<Student> selectStudents() {
        SqlSession session = MyBatisUtil.getSqlSession();
        List<Student> studentList = session.selectList(
                "com.james.dao.StudentDao.selectStudents");
        session.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtil.getSqlSession();
        int nums = session.insert(
                "com.james.dao.StudentDao.insertStudent", student);
        session.commit();
        session.close();
        return nums;
    }

    @Override
    public int updateStudent(Student student) {
        SqlSession session = MyBatisUtil.getSqlSession();
        int nums = session.insert(
                "com.james.dao.StudentDao.updateStudent", student);
        session.commit();
        session.close();
        return nums;

    }

    @Override
    public int deleteStudent(int id) {
        SqlSession session = MyBatisUtil.getSqlSession();
        int nums = session.insert(
                "com.james.dao.StudentDao.deleteStudent", 1006);
        session.commit();
        session.close();
        return nums;

    }

    
}

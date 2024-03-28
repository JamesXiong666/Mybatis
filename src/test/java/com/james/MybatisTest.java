package com.james;

import com.james.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    @Test
    public void testStart() throws IOException {
        //1.mybatis主配置文件
        String config = "mybatis-config.xml";
        //2.读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象,目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //4.获取SqlSession,SqlSession能执行sql语句
        SqlSession session = factory.openSession();
        //5.执行SqlSession的selectList()
        List<Student> studentList =session.selectList("com.james.dao.StudentDao.selectStudents");
        //6.循环输出查询结果
        studentList.forEach( student -> System.out.println(student));
        //7.关闭SqlSession，释放资源
        session.close();
    }
}

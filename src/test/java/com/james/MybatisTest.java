package com.james;

import com.james.common.MyBatisUtil;
import com.james.dao.StudentDao;
import com.james.dao.StudentDaoImpl;
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
        List<Student> studentList = session.selectList("com.james.dao.StudentDao.selectStudents");
        //6.循环输出查询结果
        studentList.forEach(student -> System.out.println(student));
        //7.关闭SqlSession，释放资源
        session.close();
    }

    StudentDao studentDao = new StudentDaoImpl();

    //测试插入
    @Test
    public void testInsert() throws IOException {
        //1.mybatis主配置文件
        String config = "mybatis.xml";
        //2.读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactory对象,目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //4.获取SqlSession
        SqlSession session = factory.openSession();
        //5. 创建保存数据的对象
        Student student = new Student();
        student.setId(2604);
        student.setName("james123");
        student.setEmail("james123@163.com");
        student.setAge(20);
        //6.执行插入操作
        session.insert("com.james.dao.StudentDao.insertStudent", student);
        //7.提交事务
        session.commit();
        //8.关闭SqlSession
        session.close();
    }

    //测试更新
    @Test
    public void testUpdate() throws IOException {
        //1.mybatis主配置文件
        String config = "mybatis.xml";
        //2.读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactory对象,目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //4.获取SqlSession
        SqlSession session = factory.openSession();
        //5. 创建保存数据的对象
        Student student = new Student();
        student.setAge(18);
        student.setId(2603);
        //6.执行更新操作
        int rows = session.update("com.james.dao.StudentDao.updateStudent", student);
        //7. 提交事务
        session.commit();
        System.out.println("修改记录的行数" + rows);
        //8.关闭SqlSession
        session.close();
    }

    // 测试删除
    @Test
    public void testDelete() throws IOException {
        //1.mybatis主配置文件
        String config = "mybatis.xml";
        //2.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactory对象,目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //4.获取SqlSession
        SqlSession session = factory.openSession();
        //5.执行删除操作
        int rows = session.delete("com.james.dao.StudentDao.deleteStudent", 2603);
        //6.提交事务
        session.commit();
        //7.关闭SqlSession
        session.close();
        System.out.println("删除记录的行数" + rows);
    }

    // 传统的Dao开发方式，通过SqlSession的相关API定位到映射文件mapper中相应id的SQL语句
    //真正对DB进行操作的工作是通过mapper中的SQL完成的.
    @Test
    public void testUtils() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> studentList = sqlSession.selectList("com.james.dao.StudentDao.selectStudents");
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    //测试select
    @Test
    public void testSelect() throws IOException {
        final List<Student> studentList = studentDao.selectStudents();
        studentList.forEach(stu -> System.out.println(stu));
    }

    //测试insert
    @Test
    public void testInsert1() throws IOException {
        Student student = new Student();
        student.setId(1006);
        student.setName("james456");
        student.setEmail("james456@163.com");
        student.setAge(28);
        int nums = studentDao.insertStudent(student);
        System.out.println("使用Dao添加数据:" + nums);
    }

    //测试update
    @Test
    public void testUpdate1() throws IOException {
        Student student = new Student();
        student.setId(1006);
        student.setAge(28);
        int nums = studentDao.updateStudent(student);
        System.out.println("使用Dao修改数据:" + nums);

    }

    //测试delete
    @Test
    public void testDelete1() throws IOException {
        int nums = studentDao.deleteStudent(1006);
        System.out.println("使用Dao修改数据:" + nums);
    }


}

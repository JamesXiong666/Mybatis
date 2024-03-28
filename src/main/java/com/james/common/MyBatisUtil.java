package com.james.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    // 定义SqlSessionFactory对象
    private static SqlSessionFactory factory = null;

    static {
        //使用静态块 创建一次SqlSessionFactory
        try {
            String config = "mybatis.xml";
            //读取配置文件
            InputStream in = Resources.getResourceAsStream(config);
            // 创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (Exception e) {
            factory = null;
            e.printStackTrace();
        }
    }

    //获取SqlSession对象
    public static SqlSession getSqlSession() {
        SqlSession session = null;
        if (factory != null) {
            session = factory.openSession();
        }
        return session;
    }
}

package com.mou;

import com.mou.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testInsert() throws IOException {


        //访问mybatis读取student数据

        //1.定义mybatis主配置文件的名称，从类路径的根开始
        String config = "mybatis-config.xml";

        //2.读取这个config文件
        InputStream in = Resources.getResourceAsStream(config);

        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);

        //5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //6.【重要】指定要执行的sql语句标识，  sql映射文件中的namespace+“.”+标签的id值   (用那个标签，填那个标签的id)
        //   例子：String sqlId = "com.mou.dao.StudentDao" + "." + "selectStudents";
        String sqlId = "com.mou.dao.StudentDao.insertStudent";

        //7.执行sql语句，通过第六步sqlId找到语句
        Student student = new Student();
        student.setId(1008);
        student.setName("赵七");
        student.setEmail("zhaoliu@sina.com");
        student.setAge(24);
        int nums= sqlSession.insert(sqlId,student);

        //8.输出结果
        System.out.println("执行insert结果"+nums);

        //mybatis默认不是提交事务的，所以要在添加，修改删除操作后 需要手工提交事务
        sqlSession.commit();

        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
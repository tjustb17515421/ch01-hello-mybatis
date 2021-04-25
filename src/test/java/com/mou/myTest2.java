package com.mou;

import com.mou.domain.Student;
import com.mou.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myTest2 {
    public static void main(String[] args) throws IOException {


        //5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //6.【重要】指定要执行的sql语句标识，  sql映射文件中的namespace+“.”+标签的id值   (用那个标签，填那个标签的id)
        String sqlId = "com.mou.dao.StudentDao.selectStudents";

        //7.执行sql语句，通过第六步sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);

        //8.输出结果
        studentList.forEach(stu -> System.out.println(stu));

        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
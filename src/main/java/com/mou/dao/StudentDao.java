package com.mou.dao;

import com.mou.domain.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {

    //查询studentz表中所有数据
    public List<Student> selectStudents();


    //插入方法
    //int :int返回值表示是数据库中sql语句执行后面影响数据库的行数
    public int insertStudent(Student student);
}

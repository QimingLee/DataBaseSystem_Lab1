package com.example.demo.mapper;

import com.example.demo.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String snum);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String snum);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
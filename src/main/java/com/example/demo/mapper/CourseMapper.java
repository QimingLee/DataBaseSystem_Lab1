package com.example.demo.mapper;

import com.example.demo.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(String cnum);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String cnum);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}
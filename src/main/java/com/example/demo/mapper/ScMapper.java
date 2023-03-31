package com.example.demo.mapper;

import com.example.demo.entity.Sc;
import com.example.demo.entity.ScKey;

public interface ScMapper {
    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    Sc selectByPrimaryKey(ScKey key);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
}
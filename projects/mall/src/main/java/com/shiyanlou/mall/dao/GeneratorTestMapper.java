package com.shiyanlou.mall.dao;

import com.shiyanlou.mall.entity.GeneratorTest;

public interface GeneratorTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GeneratorTest record);

    int insertSelective(GeneratorTest record);

    GeneratorTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GeneratorTest record);

    int updateByPrimaryKey(GeneratorTest record);
}
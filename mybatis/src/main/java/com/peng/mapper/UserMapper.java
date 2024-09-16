package com.peng.mapper;

import com.peng.mybatis.spring.PengMapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 21:09
 */
@PengMapper
public interface UserMapper {
    @Select("select 'user'")
    String selectById();
}

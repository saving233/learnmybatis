package com.study.learnmybatis.dao;

import com.study.learnmybatis.domian.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepartmentDao {

    Department getDeptById(@Param("id") Integer id);



}

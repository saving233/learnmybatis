package com.study.learnmybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.annotation.Resource;

@SpringBootTest
class LearnmybatisApplicationTests {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    public void  connectMysql(){

        Long aLong = jdbcTemplate.queryForObject("select count(*) from tbl_dept", Long.class);
        System.out.println(aLong);

    }

}

package com.study.learnmybatis.service.impl;

import com.study.learnmybatis.dao.DepartmentDao;
import com.study.learnmybatis.domian.Department;
import com.study.learnmybatis.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;


    @Override
    public Department getDeptById(Integer id) {
        return departmentDao.getDeptById(id);
    }
}

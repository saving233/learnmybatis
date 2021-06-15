package com.study.learnmybatis.service;

import com.study.learnmybatis.domian.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentService {

    public Department getDeptById(Integer id);
}

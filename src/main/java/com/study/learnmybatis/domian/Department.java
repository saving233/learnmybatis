package com.study.learnmybatis.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("department")
public class Department implements Serializable {

    private Integer id;
    private String departmentName;


    private List<Employee> emps;

    public Department(String departmentName){
        this(null,departmentName,null);
    }
}

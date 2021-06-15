package com.study.learnmybatis.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("employee")
public class Employee implements Serializable {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;

    private Department department;

    public Employee(String lastName,String email,String gender){
        this(null,lastName,email,gender,null);
    }
}

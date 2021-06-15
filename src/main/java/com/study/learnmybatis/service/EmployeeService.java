package com.study.learnmybatis.service;

import com.study.learnmybatis.domian.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface EmployeeService {

    Employee getEmpById(Integer id);



    void addEmp(Employee employee);
    void insert(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmpById(Integer id);

    Employee getEmpByMap(Map<String, Object> map);

    List<Employee> getEmpsByLastNameLike(String str);

    Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    Map<String,Employee> getEmpByIdReturnMap(Integer id);

    Employee getEmpAndDept(Integer id);

    Employee getEmpAndDept2(Integer id);

    List<Employee> getEmpAndDept3(String name);

    Employee getEmpByIdStep(Integer id);

    List<Employee> getEmpsWithDiscriminator();

    List<Employee> getEmpsByConditionIf(Employee employee);

    List<Employee> getEmpsByConditionIfWithWhere(Employee employee);

    List<Employee> getEmpsByConditionTrim(Employee employee);

    List<Employee> getEmpsByConditionChoose(Employee employee);

    void dynamicUpdateEmp(Employee employee);

    void UpdateEmpWithTrim(Employee employee);

    List<Employee> getEmpsByConditionForeach(List<Integer> ids);

    void addEmps(@Param("emps")List<Employee> emps);
    void addEmps2(@Param("emps")List<Employee> emps);

    List<Employee> getEmpsTestInnerParameter(Employee employee);

    void insertToEmp(Employee employee);

}

package com.study.learnmybatis.dao;

import com.study.learnmybatis.domian.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeDao {
    //查
    Employee getEmpById(@Param("id")Integer id);
//    ========================================================
    //增
    void addEmp(Employee employee);
    void insert(Employee employee);
//    ========================================================
    //改
    void updateEmp(Employee employee);
    //删
    void deleteEmpById(Integer id);


    Employee getEmpByMap(Map<String, Object> map);

    List<Employee> getEmpsByLastNameLike(String str);

    //多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
    //@MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("lastName")
    Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    //返回一条记录的map；key就是列名，值就是对应的值
    Map<String,Employee> getEmpByIdReturnMap(Integer id);

    //联合查询：级联属性封装结果集
    Employee getEmpAndDept(Integer id);

    //联合查询：级联属性封装结果集，用association
    Employee getEmpAndDept2(Integer id);

    List<Employee> getEmpAndDept3(String name);

    //association分步查询
    Employee getEmpByIdStep(Integer id);

    //带鉴别器查询
    List<Employee> getEmpsWithDiscriminator();
//==============================动态查询=====================================

    List<Employee> getEmpsByConditionIf(Employee employee);

    List<Employee> getEmpsByConditionIfWithWhere(Employee employee);

    List<Employee> getEmpsByConditionTrim(Employee employee);

    List<Employee> getEmpsByConditionChoose(Employee employee);

//==================================更新=========================================

    void dynamicUpdateEmp(Employee employee);
    void UpdateEmpWithTrim(Employee employee);
//==================================================================================
    List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    void addEmps(@Param("emps")List<Employee> emps);
    void addEmps2(@Param("emps")List<Employee> emps);

    List<Employee> getEmpsTestInnerParameter(Employee employee);

    void insertToEmp(Employee employee);
}

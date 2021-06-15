package com.study.learnmybatis.service.impl;

import com.study.learnmybatis.dao.EmployeeDao;
import com.study.learnmybatis.domian.Employee;
import com.study.learnmybatis.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;


    @Override
    public Employee getEmpById(Integer id) {
        return employeeDao.getEmpById(id);
    }

//    ========================================================
    @Override
    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }
    @Override
    public void addEmp(Employee employee) {
        employeeDao.addEmp(employee);
    }
//    ========================================================

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }

    @Override
    public void deleteEmpById(Integer id) {
        employeeDao.deleteEmpById(id);
    }

    @Override
    public Employee getEmpByMap(Map<String, Object> map) {
        Employee empByMap = employeeDao.getEmpByMap(map);
        return empByMap;
    }

    @Override
    public List<Employee> getEmpsByLastNameLike(String str) {
        return employeeDao.getEmpsByLastNameLike(str);
    }

    @Override
    public Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName) {
        return employeeDao.getEmpByLastNameLikeReturnMap(lastName);
    }

    @Override
    public Map<String, Employee> getEmpByIdReturnMap(Integer id) {
        return employeeDao.getEmpByIdReturnMap(id);
    }

    @Override
    public Employee getEmpAndDept(Integer id) {
        return employeeDao.getEmpAndDept(id);
    }

    @Override
    public Employee getEmpAndDept2(Integer id) {
        return employeeDao.getEmpAndDept2(id);
    }

    @Override
    public List<Employee> getEmpAndDept3(String name) {
        return employeeDao.getEmpAndDept3(name);
    }

    @Override
    public Employee getEmpByIdStep(Integer id) {
        return employeeDao.getEmpByIdStep(id);
    }

    @Override
    public List<Employee> getEmpsWithDiscriminator() {
        return employeeDao.getEmpsWithDiscriminator();
    }

    @Override
    public List<Employee> getEmpsByConditionIf(Employee employee) {
        return employeeDao.getEmpsByConditionIf(employee);
    }

    @Override
    public List<Employee> getEmpsByConditionIfWithWhere(Employee employee) {
        return employeeDao.getEmpsByConditionIfWithWhere(employee);
    }

    @Override
    public List<Employee> getEmpsByConditionTrim(Employee employee) {
        return employeeDao.getEmpsByConditionTrim(employee);
    }

    @Override
    public List<Employee> getEmpsByConditionChoose(Employee employee) {
        return employeeDao.getEmpsByConditionChoose(employee);
    }

    @Override
    public void dynamicUpdateEmp(Employee employee) {
        employeeDao.dynamicUpdateEmp(employee);
    }

    @Override
    public void UpdateEmpWithTrim(Employee employee) {
        employeeDao.UpdateEmpWithTrim(employee);
    }

    @Override
    public List<Employee> getEmpsByConditionForeach(List<Integer> ids) {
        return employeeDao.getEmpsByConditionForeach(ids);
    }

    @Override
    public void addEmps(List<Employee> emps) {
        employeeDao.addEmps(emps);
    }

    @Override
    public void addEmps2(List<Employee> emps) {
        employeeDao.addEmps2(emps);
    }

    @Override
    public List<Employee> getEmpsTestInnerParameter(Employee employee) {
        return employeeDao.getEmpsTestInnerParameter(employee);
    }

    @Override
    public void insertToEmp(Employee employee) {
        employeeDao.insertToEmp(employee);
    }

}

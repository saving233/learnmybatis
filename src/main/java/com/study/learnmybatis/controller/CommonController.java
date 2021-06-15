package com.study.learnmybatis.controller;

import com.study.learnmybatis.domian.CommonResult;
import com.study.learnmybatis.domian.Department;
import com.study.learnmybatis.domian.Employee;
import com.study.learnmybatis.service.DepartmentService;
import com.study.learnmybatis.service.EmployeeService;
import com.sun.org.glassfish.gmbal.GmbalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/getEmpById")
    public Employee getEmpById(@RequestParam("id")Integer id){
        Employee empById = employeeService.getEmpById(id);
        return empById;
    }
//========================================两种插入====================================================================
    @GetMapping("/insert")
    public CommonResult insert(Employee employee){
        employeeService.insert(employee);
        return new CommonResult(200,"insert插入成功！");
    }
    @GetMapping("/addEmp")
    public CommonResult addEmp(@RequestParam("lastName")String lastName,
                               @RequestParam("email")String email,
                               @RequestParam("gender")String gender){
        Employee employee = new Employee(null,lastName,email,gender,null);
        employeeService.addEmp(employee);

        return new CommonResult(200,"addEmp插入成功！");
    }
//============================================================================================================
    @GetMapping("/updateEmp")
    public CommonResult  updateEmp(@RequestParam("lastName")String lastName,
                                   @RequestParam("email")String email,
                                   @RequestParam("gender")String gender,
                                   @RequestParam("id")Integer id){
        Employee employee = new Employee(id,lastName,email,gender,null);
        employeeService.updateEmp(employee);
        return new CommonResult(200,"updateEmp更新成功");
    }

    @GetMapping("/deleteEmpById")
    public CommonResult deleteEmpById(@RequestParam("id")Integer id){
        employeeService.deleteEmpById(id);
        return new CommonResult(200,"deleteEmpById删除成功！");
    }

    @GetMapping("/getEmpByMap")
    public CommonResult getEmpByMap(){
        Map<String , Object> map = new HashMap<>();
        map.put("id","1");
        map.put("lastName","tom");
        Employee empByMap = employeeService.getEmpByMap(map);
        return new CommonResult(200,"getEmpByMap查询成功",empByMap);
    }

    @GetMapping("/getEmpsByLastNameLike")
    public CommonResult getEmpsByLastNameLike(){

        List<Employee> empsByLastNameLike = employeeService.getEmpsByLastNameLike("%r%");

        return new CommonResult(200,"getEmpsByLastNameLike查询成功",empsByLastNameLike);
    }

    /**
     * 多条记录封装一个map
     * @return
     */
    @GetMapping("/getEmpByLastNameLikeReturnMap")
    public CommonResult getEmpByLastNameLikeReturnMap(){
        Map<String, Employee> empByLastNameLikeReturnMap = employeeService.getEmpByLastNameLikeReturnMap("%r%");
        return new CommonResult(200,"getEmpByLastNameLikeReturnMap查询成功",empByLastNameLikeReturnMap);
    }

    /**
     * //返回一条记录的map；key就是列名，值就是对应的值
     * @return
     */
    @GetMapping("/getEmpByIdReturnMap")
    public CommonResult getEmpByIdReturnMap(){

        Map<String, Employee> empByIdReturnMap = employeeService.getEmpByIdReturnMap(1);
        return new CommonResult(200,"getEmpByIdReturnMap查询成功！",empByIdReturnMap);
    }

    @GetMapping("/getEmpAndDept")
    public CommonResult getEmpAndDept(Integer id){
        Employee empAndDept = employeeService.getEmpAndDept(id);
        return new CommonResult(200,"getEmpAndDept查询成功！",empAndDept);
    }

    @GetMapping("/getEmpAndDept2")
    public CommonResult getEmpAndDept2(Integer id){
        Employee empAndDept2 = employeeService.getEmpAndDept2(id);
        Department department = empAndDept2.getDepartment();
        log.info(department.toString());
        return new CommonResult(200,"getEmpAndDept2查询成功",empAndDept2);
    }


    @GetMapping("/getEmpAndDept3")
    public CommonResult getEmpAndDept3(String name){
        List<Employee> empAndDept3 = employeeService.getEmpAndDept3(name);
        return new CommonResult(200,"getEmpAndDept3查询成功",empAndDept3);
    }

    @GetMapping("/getDeptById")
    public CommonResult getDeptById(@RequestParam("id") Integer id){
        Department deptById = departmentService.getDeptById(id);
        return new CommonResult(200,"getDeptById查询成功！",deptById);
    }

    @GetMapping("/getEmpByIdStep")
    public CommonResult getEmpByIdStep(Integer id){
        Employee empByIdStep = employeeService.getEmpByIdStep(id);
        return new CommonResult(200,"getEmpByIdStep查询成功",empByIdStep);
    }

    @GetMapping("/getEmpsWithDiscriminator")
    public CommonResult getEmpsWithDiscriminator(){
        List<Employee> empsWithDiscriminator = employeeService.getEmpsWithDiscriminator();
        return new CommonResult(200,"getEmpsWithDiscriminator调用成功！",empsWithDiscriminator);
    }

//================================动态查询==========================================

    @GetMapping("/getEmpsByConditionIf")
    public CommonResult getEmpsByConditionIf(Employee employee){
        List<Employee> empsByConditionIf = employeeService.getEmpsByConditionIf(employee);
        return new CommonResult(200,"getEmpsByConditionIf动态查询成功！",empsByConditionIf);
    }

    @GetMapping("/getEmpsByConditionIfWithWhere")
    public CommonResult getEmpsByConditionIfWithWhere(Employee employee){
        List<Employee> empsByConditionIfWithWhere = employeeService.getEmpsByConditionIfWithWhere(employee);
        return new CommonResult(200,"getEmpsByConditionIfWithWhere动态查询成功！",empsByConditionIfWithWhere);
    }

    @GetMapping("/getEmpsByConditionTrim")
    public CommonResult getEmpsByConditionTrim(Employee employee){
        List<Employee> empsByConditionTrim = employeeService.getEmpsByConditionTrim(employee);
        return new CommonResult(200,"getEmpsByConditionTrim动态查询成功！",empsByConditionTrim);
    }

    @GetMapping("/getEmpsByConditionChoose")
    public CommonResult getEmpsByConditionChoose(Employee employee){
        List<Employee> empsByConditionChoose = employeeService.getEmpsByConditionChoose(employee);
        return new CommonResult(200,"getEmpsByConditionChoose动态查询成功！",empsByConditionChoose);
    }

    @GetMapping("/dynamicUpdateEmp")
    public CommonResult dynamicUpdateEmp(Employee employee){
        employeeService.dynamicUpdateEmp(employee);
        return new CommonResult(200,"dynamicUpdateEmp插入成功！");
    }
    @GetMapping("/UpdateEmpWithTrim")
    public CommonResult UpdateEmpWithTrim(Employee employee){
        employeeService.dynamicUpdateEmp(employee);
        return new CommonResult(200,"UpdateEmpWithTrim插入成功！");
    }

//    http://localhost:8080/getEmpsByConditionForeach?ids=1&ids=2&ids=3
    @GetMapping("/getEmpsByConditionForeach")
    public CommonResult getEmpsByConditionForeach(@RequestParam("ids") List<Integer> ids){
        List<Employee> empsByConditionForeach = employeeService.getEmpsByConditionForeach(ids);
        return new CommonResult(200,"getEmpsByConditionForeach查询成功！",empsByConditionForeach);
    }

    @GetMapping("/addEmps")
    public CommonResult addEmps(){
        List<Employee> emps =new ArrayList<>();

        emps.add(new Employee(null,"小米","15661561@qq.com","0",null));
        emps.add(new Employee(null,"华为","56456456@qq.com","1",null));
        employeeService.addEmps(emps);
        return new CommonResult(200,"addEmps插入成功！");
    }

    @GetMapping("/addEmps2")
    public CommonResult addEmps2(){
        List<Employee> emps =new ArrayList<>();

        emps.add(new Employee(null,"苹果","156233261561@qq.com","0",null));
        emps.add(new Employee(null,"雪梨","56432332356456@qq.com","1",null));
        employeeService.addEmps2(emps);
        return new CommonResult(200,"addEmps2插入成功！");
    }

    @GetMapping("/getEmpsTestInnerParameter")
    public CommonResult getEmpsTestInnerParameter(Employee employee){
        List<Employee> empsTestInnerParameter = employeeService.getEmpsTestInnerParameter(employee);
        return new CommonResult(200,"getEmpsTestInnerParameter查询成功！",empsTestInnerParameter);
    }

    @GetMapping("/insertToEmp")
    public CommonResult insertToEmp(Employee employee){
        employeeService.insertToEmp(employee);
        return new CommonResult(200,"insertToEmp插入成功！");
    }

}

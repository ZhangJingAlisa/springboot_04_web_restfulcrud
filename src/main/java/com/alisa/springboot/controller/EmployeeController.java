package com.alisa.springboot.controller;

import com.alisa.springboot.dao.DepartmentDao;
import com.alisa.springboot.dao.EmployeeDao;
import com.alisa.springboot.entities.Department;
import com.alisa.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @titile: EmployeeController
 * @description: 员工管理控制层
 * @author: Alisa
 * @create: 2019-03-07 15:57
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工返回列表页面
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认就会拼串到：classpath:/templates/XXXXXX.html
        return "/emp/list";
    }

    /**
     * 来到添加员工页面
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }
}
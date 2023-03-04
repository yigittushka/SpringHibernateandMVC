package com.turdiev.spHmvc.controller;


import com.turdiev.spHmvc.dao.EmployeeDAO;
import com.turdiev.spHmvc.entity.Employee;
import com.turdiev.spHmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String showAllEmployees (Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee (Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);
        return "redirect:/";

    }

    @RequestMapping("/updateInfo")
    public  String udateEmploee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public  String deleteEmployee(@RequestParam("empId") int id){

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }

}

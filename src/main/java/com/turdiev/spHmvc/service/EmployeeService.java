package com.turdiev.spHmvc.service;

import com.turdiev.spHmvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee (Employee employee);

    public Employee getEmployee (int id);

    public void deleteEmployee(int id);
}

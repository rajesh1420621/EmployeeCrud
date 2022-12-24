package com.example.EmployeeCrud.Service;

import com.example.EmployeeCrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployee(String id);
}

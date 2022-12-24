package com.example.EmployeeCrud.Service;

import com.example.EmployeeCrud.Error.EmployeeNotFoundException;
import com.example.EmployeeCrud.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == null || employee.getEmailId().isEmpty()) {
            employee.setId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList.stream().filter(employee -> employee.getId().
                equals(id)).findFirst().
                orElseThrow(()-> new EmployeeNotFoundException(""+"Employee Not found"+id));
    }

    @Override
    public String deleteEmployee(String id) {
         Employee employee = employeeList.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();
                 employeeList.remove(employee);
        return ("Employee deleted with id"+ id);
    }
}

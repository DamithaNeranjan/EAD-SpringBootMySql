package com.example.hotel.service;

import com.example.hotel.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployeesByHotelId(int id);

    void addEmployee (Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}

package com.example.hotel.service;

import com.example.hotel.model.Employee;
import com.example.hotel.model.Hotel;
import com.example.hotel.repository.EmployeeRepository;
import com.example.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Employee> getAllEmployeesByHotelId(int id) {
        List<Employee> employeeList = null;
        Optional<Hotel> optional = hotelRepository.findById(id);
        Hotel hotel = null;
        if (optional.isPresent()) {
            hotel = optional.get();
            employeeList = hotel.getEmployees();
        } else {
            throw new RuntimeException(" Employees not found for Hotel id :: " + id);
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(int id) {

    }
}

package com.example.hotel.controller;

import com.example.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showEmployeesOfHotel/{id}")
    public String showEmployeesOfHotel(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("listEmployeesOfHotels", employeeService.getAllEmployeesByHotelId(id));
        return "view_employees";
    }
}

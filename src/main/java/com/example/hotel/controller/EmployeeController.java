package com.example.hotel.controller;

import com.example.hotel.model.Employee;
import com.example.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showEmployeesOfHotel/{id}")
    public String showEmployeesOfHotel(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("listEmployeesOfHotels", employeeService.getAllEmployeesByHotelId(id));
        model.addAttribute("hotelID", id);
        return "view_employees";
    }

    @GetMapping("/showNewEmployeeForm/{id}")
    public String showNewEmployeeForm(@PathVariable(value = "id") int id, Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("hotelId", id);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println(employee);
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showUpdateEmployeeForm/{id}")
    public String showUpdateEmployeeForm(@PathVariable(value = "id") int id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);
        System.out.println(employee);
        System.out.println("showUpdateEmployeeForm");
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id) {

        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}

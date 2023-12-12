package vn.edu.iuh.fit.springsecuritydemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.Employee;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.State;
import vn.edu.iuh.fit.springsecuritydemo.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.springsecuritydemo.backend.services.EmployeeServices;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/em")
    public String get(){
        return employeeServices.get().toString();
    }

    @GetMapping("/save1")
    public String save1(){
        Employee employee = new Employee("name1", State.ACTIVE);
        return employeeRepository.save(employee).toString();
    }

    @GetMapping("/save2")
    public String save2(){
        Employee employee = new Employee("name2", State.INACTIVE);
        return employeeRepository.save(employee).toString();
    }

    @GetMapping("/save3")
    public String save3(){
        Employee employee = new Employee("name3", State.TERMINAL);
        return employeeRepository.save(employee).toString();
    }

    @GetMapping("/findbytype")
    public String find(){
        Employee employee = new Employee("name3", State.TERMINAL);
        return employeeRepository.findEmployeesByState(State.ACTIVE).toString();
    }



}

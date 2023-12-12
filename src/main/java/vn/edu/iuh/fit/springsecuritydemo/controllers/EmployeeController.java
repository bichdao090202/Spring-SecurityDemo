package vn.edu.iuh.fit.springsecuritydemo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.Employee;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.State;
import vn.edu.iuh.fit.springsecuritydemo.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.springsecuritydemo.backend.services.EmployeeServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public String getPage(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
//    public String getPage(Model model){
//        List<Employee> productPage = employeeServices.get();
//        model.addAttribute("productPage",productPage);
        Page<Employee> productPage = employeeServices.findPaging(page-1,size,"id","asc");
        model.addAttribute("productPage",productPage);

        int totalpage = productPage.getTotalPages();

        if(totalpage>0){
            List<Integer> pageNumber = IntStream.rangeClosed(1,totalpage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumber);
        }
        return "index";
    }

    @GetMapping("/edit")
    public String edit(HttpSession session, Model model, @RequestParam long id){
        Employee employee = employeeRepository.findById(id);
        session.setAttribute("id", id);
        model.addAttribute("e",employee);
        return "form";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam Long id){
        employeeRepository.deleteById(id);
        List<Employee> productPage = employeeServices.get();
        model.addAttribute("productPage",productPage);
        return "index";
    }

    @GetMapping("/update")
    public String update(HttpSession session, Model model, @RequestParam String name){
        System.out.println(name);
        Employee employee = new Employee((Long) session.getAttribute("id"),name, State.ACTIVE);
        employeeRepository.save(employee);
        List<Employee> productPage = employeeServices.get();
        model.addAttribute("productPage",productPage);
        return "index";
    }

    @GetMapping("/get/{name}")
    public String get2(@PathVariable String name, Model model){
        List<Employee> productPage = employeeRepository.getList2(name);
        model.addAttribute("productPage",productPage);
        return "index";
    }

}

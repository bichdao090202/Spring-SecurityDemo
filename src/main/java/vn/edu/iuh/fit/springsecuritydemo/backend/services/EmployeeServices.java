package vn.edu.iuh.fit.springsecuritydemo.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.Employee;
import vn.edu.iuh.fit.springsecuritydemo.backend.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> get(){
        return employeeRepository.getList();
    }

//    public Employee save(Employee employee){
//        return employeeRepository.save(employee);
//    }

    public Page<Employee> findPaging(int no, int size, String sortBy, String direct){
        Sort sort = Sort.by(Sort.Direction.fromString(direct),sortBy);
        Pageable pageable = PageRequest.of(no,size,sort);
        return employeeRepository.findAll(pageable);
    }
}

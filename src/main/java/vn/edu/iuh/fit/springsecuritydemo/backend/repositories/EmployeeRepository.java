package vn.edu.iuh.fit.springsecuritydemo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.Employee;
import vn.edu.iuh.fit.springsecuritydemo.backend.models.State;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT * FROM EMPLOYEE WHERE state IN (0, 1)", nativeQuery = true)
    List<Employee> getList();

    @Query(value = "SELECT * FROM EMPLOYEE WHERE name = :name", nativeQuery = true)
    List<Employee> getList2(String name);

    Employee save(Employee employee);

    List<Employee> findEmployeesByState(State state);

    Employee findById(long id);

}

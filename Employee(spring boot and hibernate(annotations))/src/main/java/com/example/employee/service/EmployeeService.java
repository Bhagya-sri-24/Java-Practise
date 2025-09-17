package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repo.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> findAll() { return repo.findAll(); }

    public Employee findById(Long id) { return repo.findById(id).orElse(null); }

    public Employee create(Employee e) { return repo.save(e); }

    public Employee update(Long id, Employee data) {
        return repo.findById(id).map(e -> {
            e.setFirstName(data.getFirstName());
            e.setLastName(data.getLastName());
            e.setEmail(data.getEmail());
            e.setSalary(data.getSalary());
            e.setDepartment(data.getDepartment());
            return repo.save(e);
        }).orElse(null);
    }

    public void delete(Long id) { repo.deleteById(id); }
}

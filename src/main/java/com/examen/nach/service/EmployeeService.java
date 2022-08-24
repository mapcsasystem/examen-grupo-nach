package com.examen.nach.service;

import com.examen.nach.entity.Employee;
import com.examen.nach.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getByIdEmployee(long id){
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> findByNameAndLastName(String name, String lastName){
        return employeeRepository.findByNameAndLastName(name,lastName);
    }

  public List<Employee> findByJobId(Long jobId){
        return employeeRepository.findByJobId(jobId);
    }


}

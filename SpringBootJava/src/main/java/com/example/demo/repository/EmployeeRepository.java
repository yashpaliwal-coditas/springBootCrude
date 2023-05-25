package com.example.demo.repository;


import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}

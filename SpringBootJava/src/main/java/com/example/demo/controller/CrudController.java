package com.example.demo.controller;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crud")
public class CrudController {
	private EmployeeService employeeService;
    public CrudController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployee(){
        System.out.println("getall");
        List<Employee> employeeList = employeeService.getAllEmployees();
        if (employeeList == null || employeeList.isEmpty()) {
            ApiResponse<List<Employee>> response = new ApiResponse<>(true, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            ApiResponse<List<Employee>> response = new ApiResponse<>(false, employeeList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping( "/byid{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable("id") int id){
        System.out.println("get by id");
        Optional<Employee> employeeList = employeeService.getEmployeeById(id);
        if (employeeList == null ) {
            ApiResponse<Employee> response = new ApiResponse<>(true, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            ApiResponse<Employee> response = new ApiResponse<>(false, employeeList.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}

package com.example.Employee.List.Controller;


import com.example.Employee.List.Exception.ResourceNotFoundException;
import com.example.Employee.List.Model.Employee;
import com.example.Employee.List.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/employee")
public class EmployeeController {

@Autowired
    private EmployeeRepository employeeRepository;


@GetMapping
public List<Employee> getaAllEmployee(){

    return employeeRepository.findAll();
}

// Build Create Employee REST API

    @PostMapping
    public Employee createemployee( @RequestBody Employee employee){

    return  employeeRepository.save(employee);


    }
    // Build get Employee by id REST API
@GetMapping(path ="{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){

Employee employee= employeeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));

return  ResponseEntity.ok(employee);
    }
// Build Update Empoloyee REST API

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(long id ,Employee employeeDetails){
Employee updateEmployee = employeeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Employee does not exists with id:" +id));


        updateEmployee.setFirstname(employeeDetails.getFirstname());
        updateEmployee.setLastname(employeeDetails.getLastname());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }


    // Build Delete Employee REST API

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

    Employee employee= employeeRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Employee does not exists with id: " +id));

    employeeRepository.delete(employee);

    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

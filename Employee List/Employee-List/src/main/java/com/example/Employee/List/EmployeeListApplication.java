package com.example.Employee.List;

import com.example.Employee.List.Model.Employee;
import com.example.Employee.List.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeListApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeListApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public void run(String... args) throws Exception {
		 Employee employee=new Employee();
		 employee.setFirstname("Ramesh");
		 employee.setLastname("Singh");
		 employee.setEmailId("ramesh@gmail.com");
		 employeeRepository.save(employee);


		Employee employee1=new Employee();
		employee1.setFirstname("Ankur");
		employee1.setLastname("Bhatia");
		employee1.setEmailId("ankur@gmail.com");
		employeeRepository.save(employee);

	}
}

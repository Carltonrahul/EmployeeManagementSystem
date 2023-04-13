package com.example.Employee.List.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "employee")
public class Employee {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(name = "first_name")
    private String firstname;

@Column(name= "last_name")
    private String lastname ;
@Column(name = "email_Id")
    private String emailId;

}

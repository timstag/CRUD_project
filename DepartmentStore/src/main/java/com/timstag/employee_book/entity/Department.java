package com.timstag.employee_book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "department", nullable = false, unique = true)
    private String name;


//    @OneToMany//(targetEntity = Employee.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "de_fk")
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;


}

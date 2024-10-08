package com.timstag.employee_book.repository;

import com.timstag.employee_book.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

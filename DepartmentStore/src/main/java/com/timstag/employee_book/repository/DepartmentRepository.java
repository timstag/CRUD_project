package com.timstag.employee_book.repository;

import com.timstag.employee_book.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Optional<Department> findByName(String name);
    public void deleteByName(String name);
}

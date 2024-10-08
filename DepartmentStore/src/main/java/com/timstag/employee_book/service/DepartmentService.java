package com.timstag.employee_book.service;

import com.timstag.employee_book.dto.DepartmentDto;
import com.timstag.employee_book.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

   DepartmentDto getDepartmentByName(String name);

    List<DepartmentDto> getAllDepartment();

    DepartmentDto updateDepartment(String name, DepartmentDto updateDepartment);

    void deleteDepartment(String name);

}

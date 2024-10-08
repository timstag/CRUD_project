package com.timstag.employee_book.mapper;
import com.timstag.employee_book.dto.DepartmentDto;
import com.timstag.employee_book.dto.EmployeeDto;
import com.timstag.employee_book.entity.Department;
import com.timstag.employee_book.entity.Employee;
import com.timstag.employee_book.mapper.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {

    // Converts Department entity to DepartmentDto
    public static DepartmentDto mapToDepartmentDto(Department department) {
        List<EmployeeDto> employeeDtos = department.getEmployees().stream()
                .map(EmployeeMapper::mapToEmployeeDto) // Assuming you have an EmployeeMapper
                .collect(Collectors.toList());

        return new DepartmentDto(
                department.getId(),
                department.getName(),
                employeeDtos // map the list of employees
        );
    }

    // Converts DepartmentDto to Department entity
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        List<Employee> employees = departmentDto.getEmployees().stream()
                .map(EmployeeMapper::mapToEmployee) // Assuming you have an EmployeeMapper
                .collect(Collectors.toList());

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                employees
        );

        // Set the department reference in each employee (bidirectional)
        for (Employee employee : employees) {
            employee.setDepartment(department);
        }

        return department;
    }
}




//package com.timstag.employee_book.mapper;
//
//
//import com.timstag.employee_book.dto.DepartmentDto;
//import com.timstag.employee_book.entity.Department;
//import com.timstag.employee_book.entity.Employee;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
////@RequiredArgsConstructor
////@AllArgsConstructor
//public class DepartmentMapper {
//    public static DepartmentDto mapToDepartmentDto(Department department){
//        return new DepartmentDto(
//                department.getId(),
//                department.getName()
//        );
//    }
//
//    public static Department mapToDepartment(DepartmentDto departmentDto){
//        return new Department(
//                departmentDto.getId(),
//                departmentDto.getName()
//        );
//    }
//}

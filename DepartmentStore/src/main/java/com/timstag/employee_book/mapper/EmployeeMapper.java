package com.timstag.employee_book.mapper;

import com.timstag.employee_book.dto.EmployeeDto;
import com.timstag.employee_book.entity.Department;
import com.timstag.employee_book.entity.Employee;
import lombok.AllArgsConstructor;
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                null

        );
    }
}

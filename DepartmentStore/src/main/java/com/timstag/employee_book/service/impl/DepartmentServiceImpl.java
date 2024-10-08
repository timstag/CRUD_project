package com.timstag.employee_book.service.impl;

import com.timstag.employee_book.dto.DepartmentDto;
import com.timstag.employee_book.entity.Department;
import com.timstag.employee_book.exception.ResourceNotFoundException;
import com.timstag.employee_book.mapper.DepartmentMapper;
import com.timstag.employee_book.repository.DepartmentRepository;
import com.timstag.employee_book.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }


    @Override
    public DepartmentDto getDepartmentByName(String name) {

        Department department = departmentRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Department with the given id does not exist : " + name));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {

        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department)
                -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(String name, DepartmentDto updateDepartment) {
Department department = departmentRepository.findByName(name)
        .orElseThrow(() -> new ResourceNotFoundException
                ("Department with the given id does not exist : " + name));


department.setName(updateDepartment.getName());
Department  updateDepartmentObj = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updateDepartmentObj);
    }

    @Override
    public void deleteDepartment(String name) {
        Department department = departmentRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Department with the given id does not exist : " + name));

        departmentRepository.deleteByName(name);

    }

}

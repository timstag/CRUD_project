package com.timstag.employee_book.controller;

import com.timstag.employee_book.dto.DepartmentDto;
import com.timstag.employee_book.entity.Department;
import com.timstag.employee_book.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dept")
public class DepartmentController {
    private DepartmentService departmentService;
    @PostMapping("/add")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

   @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") String name){
        DepartmentDto departmentDto = departmentService.getDepartmentByName(name);
        return ResponseEntity.ok(departmentDto);
    }
@GetMapping("/get/all")
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }
    @PutMapping("{id}")
public ResponseEntity<DepartmentDto> updateDepartment
        (@PathVariable("id") String name, @RequestBody DepartmentDto updateDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(name, updateDepartment);
        return ResponseEntity.ok(departmentDto);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") String name){
        departmentService.deleteDepartment(name);
        return ResponseEntity.ok("Department deleted successfully!");
}

}

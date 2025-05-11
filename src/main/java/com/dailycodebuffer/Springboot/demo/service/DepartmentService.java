package com.dailycodebuffer.Springboot.demo.service;

import com.dailycodebuffer.Springboot.demo.entity.Department;
import com.dailycodebuffer.Springboot.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentsList();

    Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long deptId);

    List<Department> saveAllDepartments(List<Department> departments);

    Department updateDepartment(Long deptId, Department department);

    Department fetchDepartmentByName(String deptName);
}

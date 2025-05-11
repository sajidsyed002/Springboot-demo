package com.dailycodebuffer.Springboot.demo.service;

import com.dailycodebuffer.Springboot.demo.entity.Department;
import com.dailycodebuffer.Springboot.demo.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentsList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> dept = departmentRepository.findById(deptId);

        if(!dept.isPresent())
            throw new DepartmentNotFoundException("Dept not available");
        return dept.get();
    }

    @Override
    public void deleteDepartmentById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    @Override
    public List<Department> saveAllDepartments(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department depDb = departmentRepository.findById(deptId).get();
          depDb.setDeptAddress(department.getDeptAddress());
          depDb.setDeptCode(department.getDeptCode());
          depDb.setDeptName(department.getDeptName());
          return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String deptName) {
        return departmentRepository.findByDeptNameIgnoreCase(deptName);
    }
}

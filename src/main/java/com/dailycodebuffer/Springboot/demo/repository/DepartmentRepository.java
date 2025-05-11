package com.dailycodebuffer.Springboot.demo.repository;

import com.dailycodebuffer.Springboot.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //@Query(value = "", nativeQuery =true)
    public Department findByDeptNameIgnoreCase(String deptName);
}

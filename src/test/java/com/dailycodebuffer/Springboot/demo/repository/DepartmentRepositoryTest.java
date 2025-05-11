package com.dailycodebuffer.Springboot.demo.repository;

import com.dailycodebuffer.Springboot.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().deptName("Mech").deptCode("ME090").deptAddress("Italy").build();
        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDept(){
        Department dept = departmentRepository.findById(1L).get();
        assertEquals(dept.getDeptName(), "Mech");
    }

}
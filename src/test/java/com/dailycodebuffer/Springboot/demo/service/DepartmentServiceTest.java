package com.dailycodebuffer.Springboot.demo.service;

import com.dailycodebuffer.Springboot.demo.entity.Department;
import com.dailycodebuffer.Springboot.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().deptName("IT")
                .deptAddress("goa")
                .deptCode("IT009")
                .deptId(123L)
                .build();

        Mockito.when(departmentRepository.findByDeptNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("GEt data based on valid dept name")
    public void whenValidDeptName_thenDeptShouldFound(){
        String deptName = "IT";
        Department found = departmentService.fetchDepartmentByName(deptName);

        assertEquals(deptName, null !=found ? found.getDeptName():"s");
    }
}
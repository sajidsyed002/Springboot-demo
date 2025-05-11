package com.dailycodebuffer.Springboot.demo.controller;

import com.dailycodebuffer.Springboot.demo.entity.Department;
import com.dailycodebuffer.Springboot.demo.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    //property based DI
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside saveDept of DeptController");
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/departments")
    public List<Department> saveAllDepartments(@RequestBody List<Department> departments){
        return departmentService.saveAllDepartments(departments);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentsList(){
        LOGGER.info("inside fetchDepartmentsList of DeptController");
        return departmentService.fetchDepartmentsList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(deptId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long deptId){
         departmentService.deleteDepartmentById(deptId);
         return "dept delted successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long deptId, @RequestBody Department department){
        return departmentService.updateDepartment(deptId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String deptName){
        return departmentService.fetchDepartmentByName(deptName);
    }













    /* JSON body to give in insomnia
    [
	{
	"deptName":"ITI",
	"deptAddress":"BANGLR",
	"deptCode":"IT5000"
},{
	"deptName":"ECE",
	"deptAddress":"HYD",
	"deptCode":"IT5001"
},
	{
	"deptName":"MPC",
	"deptAddress":"CHN",
	"deptCode":"IT5002"
}
	]
     */
}

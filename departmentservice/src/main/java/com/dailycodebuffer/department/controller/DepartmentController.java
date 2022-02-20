package com.dailycodebuffer.department.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.service.DepartmentService;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
	private static final Logger log = LogManager.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{departmentId}")
	public Department findDepartmentById(@PathVariable Long departmentId) {
		log.info("inside findDepartmentById of DepartmentController");
		return departmentService.findDepartmentById(departmentId);
		
	}
}

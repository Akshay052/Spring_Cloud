package com.dailycodebuffer.department.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private static final Logger log = LogManager.getLogger(DepartmentService.class);  
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
		
	}
	
	public Department findDepartmentById(Long departmentId) {
		log.info("inside saveDepartment of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
		
	}
}

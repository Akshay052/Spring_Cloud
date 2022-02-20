package com.dailycodebuffer.userservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.userservice.VO.ResponseTemplateVO;
import com.dailycodebuffer.userservice.entity.User;
import com.dailycodebuffer.userservice.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	private static final Logger log = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("inside saveDepartment of UserController");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{userId}")
	public User findUserById(@PathVariable Long userId) {
		log.info("inside findDepartmentById of UserController");
		return userService.findUserById(userId);
		
	}
	
	@GetMapping("/userwithdept/{userId}")
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		return userService.getUserWithDepartment(userId);
	}
}

package com.dailycodebuffer.userservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.userservice.VO.Department;
import com.dailycodebuffer.userservice.VO.ResponseTemplateVO;
import com.dailycodebuffer.userservice.entity.User;
import com.dailycodebuffer.userservice.repository.UserRepository;

@Service
public class UserService {
	private static final Logger log = LogManager.getLogger(UserService.class);  
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("inside saveUser of UserService");
		return userRepository.save(user);
		
	}
	
	public User findUserById(Long userId) {
		log.info("inside findUserById of UserService");
		return userRepository.findByUserId(userId);
		
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user= userRepository.findByUserId(userId);
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"
				+ user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(dept);
		return vo;
	}
}

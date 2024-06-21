package com.arc.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arc.redis.entity.Roles;
import com.arc.redis.entity.User;
import com.arc.redis.model.UserDTO;
import com.arc.redis.service.UserDAOService;


@RestController
@RequestMapping("/com/arc/rediscluster")
public class UserController  {

	@Autowired
	UserDAOService daoService;
	
	@PostMapping("/user")
	public void createNewUser(@RequestBody UserDTO userDTO)
	{
		User user = new User(userDTO.getUserName(), userDTO.getPassword(), 1);
		Roles roles = new Roles(userDTO.getRoles().getRoles());
		user.addRoles(roles);
		daoService.createUser(user);
		System.out.println("User created successfully");
	}

	
//	@GetMapping("/hash")
//	public void hashGet()
//	{
//		User user = new User("abc", "t3mpt-c0n!c@l-d!v!d3", 1);
//		
//		Roles roles = new Roles("Admin");
//		
//		user.setRoles(roles);
//		user.addRoles(roles);
//		
//		daoService.createUser(user);
//		System.out.println("Hash mapping get request.");
//	}
}


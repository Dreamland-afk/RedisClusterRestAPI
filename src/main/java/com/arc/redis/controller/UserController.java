package com.arc.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arc.redis.configuration.RedisClusterConfigurationProperties;
import com.arc.redis.entity.Roles;
import com.arc.redis.entity.User;
import com.arc.redis.model.UserDTO;
import com.arc.redis.service.UserDAOService;


@RestController
@RequestMapping("/com/arc/rediscluster")
public class UserController  {

	@Autowired
	UserDAOService daoService;
	
	@Autowired
	RedisClusterConfigurationProperties clusterConfigurationProperties;
	
	@PostMapping("/user")
	public void createNewUser(@RequestBody UserDTO userDTO)
	{
		User user = new User(userDTO.getUserName(), userDTO.getPassword(), 1);
		Roles roles = new Roles(userDTO.getRoles().getRoles());
		user.addRoles(roles);
		daoService.createUser(user);
		System.out.println("User created successfully");
	}
	
	

	
	@GetMapping("/hash")
	public void hashGet()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		   System.out.println( authentication.getAuthorities());
		    System.out.println(currentUserName);
		}
		
		System.out.println("Hash mapping get request.");
		
		System.out.println(clusterConfigurationProperties.getNodes());
	}
}


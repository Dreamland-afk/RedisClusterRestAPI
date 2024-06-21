package com.arc.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arc.redis.entity.User;
import com.arc.redis.repo.IuserRepo;

@Service
public class UserDAOService {

	@Autowired
	IuserRepo iuserRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void createUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		iuserRepo.save(user);
	}
}

package com.arc.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arc.redis.entity.User;
import com.arc.redis.repo.IuserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IuserRepo iuserRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = iuserRepo.findByUserName(username);
		
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		
		UserDetailsImpl  userDetailsImpl = new UserDetailsImpl(user);
		
		return userDetailsImpl;
	}
	

}

package com.arc.redis.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.arc.redis.entity.User;


public class UserDetailsImpl  implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	
	public UserDetailsImpl(User user) {
	
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.authorities = Arrays.stream(user.getRoles().getRoles().split(","))
                .map(role -> new SimpleGrantedAuthority(role.trim()))
                .collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}

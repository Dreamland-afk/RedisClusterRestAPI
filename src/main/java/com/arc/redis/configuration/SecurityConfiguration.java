package com.arc.redis.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Autowired
	UserDetailsService UserDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
//				.requestMatchers("/hash").hasRole("hash")
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
			);
		http.csrf(c -> c.disable());

		return http.build();
	}
	
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(UserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
		
	}
	

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}

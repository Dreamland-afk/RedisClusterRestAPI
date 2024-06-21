package com.arc.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arc.redis.entity.User;

@Repository
public interface IuserRepo  extends JpaRepository<User, String>{

	public User findByUserName(String name);
}

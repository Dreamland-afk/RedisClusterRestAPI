package com.arc.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arc.redis.entity.Roles;

public interface IRolesRepo extends JpaRepository<Roles, Integer> {

}

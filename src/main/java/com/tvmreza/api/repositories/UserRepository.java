package com.tvmreza.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

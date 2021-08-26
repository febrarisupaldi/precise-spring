package com.precise.models.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.precise.models.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}

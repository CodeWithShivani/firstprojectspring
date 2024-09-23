package com.first.springproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.springproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findByMobileNumber(String mobileNumber);
}

package com.assessment.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.assessment.app.model.User;

public interface ValidationRepository extends CrudRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
}

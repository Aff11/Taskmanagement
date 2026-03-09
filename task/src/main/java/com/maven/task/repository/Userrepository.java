package com.maven.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven.task.model.User;

public interface Userrepository extends JpaRepository<User,Long>{

	User findByName(String name);

	User findByEmail(String email);
}

package com.maven.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven.task.model.Task;

public interface Taskrepository extends JpaRepository<Task,Long>{

}

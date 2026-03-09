package com.maven.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.task.model.Task;
import com.maven.task.repository.Taskrepository;

@Service
public class Taskservice {

	 @Autowired
	    private Taskrepository taskRepository;

	    public Task createTask(Task task){
	        return taskRepository.save(task);
	    }

	    public List<Task> getAllTasks(){
	        return taskRepository.findAll();
	    }
	    
	    public Task getTaskById(Long id){
	        return taskRepository.findById(id).orElse(null);
	    }

	public Task updateTask(Long id, Task task){
        Task existing = taskRepository.findById(id).orElse(null);

        if(existing != null){
            existing.setTitle(task.getTitle());
            existing.setDescription(task.getDescription());
            existing.setStatus(task.getStatus());

            return taskRepository.save(existing);
        }

        return null;
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}

package com.maven.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.task.dto.Loginrequest;
import com.maven.task.model.User;
import com.maven.task.repository.Userrepository;

@Service
public class Userservice {

	@Autowired
    private Userrepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

	public User login(Loginrequest request) {
		// TODO Auto-generated method stub
		 User user = userRepository.findByEmail(request.getEmail());

		    if (user != null && user.getPassword().equals(request.getPassword())) {
		        return user;
		    }
		    
	    throw new RuntimeException("Invalid email or password");
	}
}

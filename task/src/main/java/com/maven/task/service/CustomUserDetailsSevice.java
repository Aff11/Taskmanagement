package com.maven.task.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maven.task.model.User;
import com.maven.task.repository.Userrepository;

@Service
public class CustomUserDetailsSevice implements UserDetailsService{

	@Autowired
    private Userrepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(name);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}

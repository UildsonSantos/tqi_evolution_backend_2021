package com.tqi.uildsonsantos.creditmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tqi.uildsonsantos.creditmanager.entities.User;
import com.tqi.uildsonsantos.creditmanager.repositories.UserRepository;
import com.tqi.uildsonsantos.creditmanager.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
}

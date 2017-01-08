package com.messageboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messageboard.domain.User;
import com.messageboard.repo.UserRepsitory;

@Service
public class UserService {
	
	private UserRepsitory userRepository;

	@Autowired
	public UserService(UserRepsitory userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(User user) {
		this.userRepository.save(user);
	}
	
}

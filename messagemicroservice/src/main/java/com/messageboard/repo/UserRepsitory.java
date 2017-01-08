package com.messageboard.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.messageboard.domain.User;

public interface UserRepsitory extends CrudRepository<User, Integer> {

	
	// Do not expose delete methods
	@Override
	@RestResource(exported = false)
	void delete(Integer arg0);

	@Override
	@RestResource(exported = false)
	void delete(User arg0);
	
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends User> arg0);
}

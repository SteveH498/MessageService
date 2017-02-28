package com.messageboard.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.messageboard.domain.BoardUser;

public interface UserRepsitory extends CrudRepository<BoardUser, Integer> {
	
	
	BoardUser findByName(String name);

	
	// Do not expose delete methods
	@Override
	@RestResource(exported = false)
	void delete(Integer arg0);

	@Override
	@RestResource(exported = false)
	void delete(BoardUser arg0);
	
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends BoardUser> arg0);
}

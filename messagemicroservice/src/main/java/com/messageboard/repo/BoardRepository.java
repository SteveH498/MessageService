package com.messageboard.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.messageboard.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Integer> {
	
	
	// Do not expose delete methods
	@Override
	@RestResource(exported = false)
	void delete(Integer arg0);

	@Override
	@RestResource(exported = false)
	void delete(Board arg0);
	
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends Board> arg0);
	
	
}

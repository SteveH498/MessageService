package com.messageboard.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.messageboard.domain.BoardMessage;

public interface MessageRepository extends CrudRepository<BoardMessage, Integer> {

	List<BoardMessage> findByBoardUserName(@Param("boardUser") String name);

	// Do not expose delete methods
	@Override
	@RestResource(exported = false)
	void delete(Integer arg0);

	@Override
	@RestResource(exported = false)
	void delete(BoardMessage arg0);
	
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends BoardMessage> arg0);
	

}

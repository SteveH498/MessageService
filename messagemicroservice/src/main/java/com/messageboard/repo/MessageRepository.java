package com.messageboard.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.messageboard.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {

	List<Message> findByUser(@Param("user") String user);

	@Override
	@RestResource(exported = false)
	void delete(Integer arg0);

	@Override
	@RestResource(exported = false)
	void delete(Message arg0);
	
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends Message> arg0);
	

}

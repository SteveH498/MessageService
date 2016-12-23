package com.messageboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messageboard.domain.Message;
import com.messageboard.repo.MessageRepository;

/*
 * Service class for creating and querying Messages.
 */

@Service
public class MessageService {

	private MessageRepository messageRepository;

	@Autowired
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public void createMessage(String user, String message) {
		messageRepository.save(new Message(user, message));
	}

	public Iterable<Message> getAllMessages() {
		return messageRepository.findAll();
	}
	
	
	public List<Message> getAllMessagesOfUser(String user){
		return messageRepository.findByUser(user);
	}

	public long total() {
		return messageRepository.count();
	}

}

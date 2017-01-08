package com.messageboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messageboard.domain.Board;
import com.messageboard.domain.Message;
import com.messageboard.domain.User;
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

	public void createMessage( User user, Board board, String message) {
		messageRepository.save(new Message(user, board, message));
	}

	public Iterable<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public List<Message> getAllMessagesOfUser(String name) {
		return messageRepository.findByUserName(name);
	}

	public long total() {
		return messageRepository.count();
	}

}

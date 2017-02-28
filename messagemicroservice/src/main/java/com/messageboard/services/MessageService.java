package com.messageboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messageboard.domain.Board;
import com.messageboard.domain.BoardMessage;
import com.messageboard.domain.BoardUser;
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

	public void createMessage( BoardUser user, Board board, String message) {
		messageRepository.save(new BoardMessage(user, board, message));
	}

	public Iterable<BoardMessage> getAllMessages() {
		return messageRepository.findAll();
	}

	public List<BoardMessage> getAllMessagesOfUser(String name) {
		return messageRepository.findByBoardUserName(name);
	}

	public long total() {
		return messageRepository.count();
	}

}

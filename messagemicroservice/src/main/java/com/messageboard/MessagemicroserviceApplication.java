package com.messageboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.messageboard.domain.Board;
import com.messageboard.domain.BoardUser;
import com.messageboard.services.BoardService;
import com.messageboard.services.MessageService;
import com.messageboard.services.UserService;


@SpringBootApplication
public class MessagemicroserviceApplication implements CommandLineRunner {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;

	@Autowired
	private BoardService boardService;
	
	//@Autowired
	//private UserRepsitory userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MessagemicroserviceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		BoardUser user1 = new BoardUser("Steve", "steve@test.com", BCrypt.hashpw("test_password", BCrypt.gensalt()));
		userService.createUser(user1);

		BoardUser user2 = new BoardUser("Pete", "pete@test.com", BCrypt.hashpw("another_test_password", BCrypt.gensalt()));
		userService.createUser(user2);

		BoardUser user3 = new BoardUser("John", "john@test.com", BCrypt.hashpw("another_test_password1", BCrypt.gensalt()));
		userService.createUser(user3);

		ArrayList<BoardUser> boardUsers = new ArrayList<BoardUser>();
		boardUsers.add(user1);
		boardUsers.add(user2);

		Board board1 = new Board("Test Board");
		board1.setBoardUsers(boardUsers);
		board1.addBoardUser(user3);
		boardService.createBoard(board1);

		messageService.createMessage(user1, board1, "Hello world 1!");
		messageService.createMessage(user1, board1, "Hello world 2!");
		messageService.createMessage(user2, board1, "Another hello world 2!");

		messageService.getAllMessages().forEach(message -> System.out.println(message));
		messageService.getAllMessagesOfUser("Steve").forEach(message -> System.out.println(message));

	}
	
}

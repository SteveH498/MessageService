package com.messageboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.messageboard.domain.Board;
import com.messageboard.domain.User;
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

	public static void main(String[] args) {
		SpringApplication.run(MessagemicroserviceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		User user1 = new User("Steve", "steve@test.com", BCrypt.hashpw("test_password", BCrypt.gensalt()));
		userService.createUser(user1);

		User user2 = new User("Pete", "pete@test.com", BCrypt.hashpw("another_test_password", BCrypt.gensalt()));
		userService.createUser(user2);

		User user3 = new User("John", "john@test.com", BCrypt.hashpw("another_test_password1", BCrypt.gensalt()));
		userService.createUser(user3);

		ArrayList<User> boardUsers = new ArrayList<User>();
		boardUsers.add(user1);
		boardUsers.add(user2);

		Board board1 = new Board("Test Board");
		board1.setUsers(boardUsers);
		board1.addUser(user3);
		boardService.createBoard(board1);

		messageService.createMessage(user1, board1, "Hello world 1!");
		messageService.createMessage(user1, board1, "Hello world 2!");
		messageService.createMessage(user2, board1, "Another hello world 2!");

		messageService.getAllMessages().forEach(message -> System.out.println(message));
		messageService.getAllMessagesOfUser("Steve").forEach(message -> System.out.println(message));

	}
}

package com.messageboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.messageboard.services.MessageService;

@SpringBootApplication
public class MessagemicroserviceApplication implements CommandLineRunner {

	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(MessagemicroserviceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		messageService.createMessage("Steve", "Hello world!");
		messageService.createMessage("Andy", "This is a test message!");
		messageService.createMessage("John", "This is another test message");

		messageService.getAllMessages().forEach(message -> System.out.println(message));
		messageService.getAllMessagesOfUser("Steve").forEach(message -> System.out.println(message));

	}
}

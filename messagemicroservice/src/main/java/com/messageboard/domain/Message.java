package com.messageboard.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6001259766243510222L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String message;

	@ManyToOne
	private User user;

	@OneToOne
	private Board board;

	public Message(User user, Board board, String message) {
		super();
		this.user = user;
		this.message = message;
		this.board = board;
	}

	protected Message() {

	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", message=" + message + "]";
	}

}

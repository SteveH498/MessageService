package com.messageboard.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String user;

	@Column
	private String message;

	public Message(String user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

	protected Message() {

	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", message=" + message + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

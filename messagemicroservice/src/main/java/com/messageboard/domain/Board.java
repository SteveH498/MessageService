package com.messageboard.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4417130010155001587L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String title;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "board")
	private List<Message> messages;

	@ManyToMany
	@JoinTable(name = "User_Board", joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Board_Id", referencedColumnName = "id"))
	private List<User> users;

	public Board(String title) {
		super();
		this.title = title;
	}

	protected Board() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public void addUser(User user){
		if(this.users != null){
			this.users.add(user);
		}		
	}

}

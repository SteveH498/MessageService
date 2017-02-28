package com.messageboard.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;;

@Entity
public class BoardUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 573677329115257971L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String passwordHash;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "boardUser")
	private List<BoardMessage> boardMessages;

	@ManyToMany // (mappedBy = "boardUsers")
	@JoinTable(name = "User_Board", joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Board_Id", referencedColumnName = "id"))
	private List<Board> boards;

	public BoardUser(String name, String email, String passwordHash) {
		super();
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
	}

	protected BoardUser() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	
	public List<BoardMessage> getBoardMessages() {
		return boardMessages;
	}

	public void setBoardMessages(List<BoardMessage> boardMessages) {
		this.boardMessages = boardMessages;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", passwordHash=" + passwordHash + "]";
	}

}

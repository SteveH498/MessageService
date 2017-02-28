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
	private List<BoardMessage> boardMessages;

	@ManyToMany(mappedBy = "boards")
	//@JoinTable(name = "User_Board", joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Board_Id", referencedColumnName = "id"))
	private List<BoardUser> boardUsers;

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

	public List<BoardMessage> getBoardMessages() {
		return boardMessages;
	}

	public void setBoardMessages(List<BoardMessage> boardMessages) {
		this.boardMessages = boardMessages;
	}

	public List<BoardUser> getBoardUsers() {
		return boardUsers;
	}

	public void setBoardUsers(List<BoardUser> boardUsers) {
		this.boardUsers = boardUsers;
	}
	
	
	public void addBoardUser(BoardUser boardUser){
		if(this.boardUsers != null){
			this.boardUsers.add(boardUser);
		}		
	}

}

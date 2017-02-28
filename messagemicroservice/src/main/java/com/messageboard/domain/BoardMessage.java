package com.messageboard.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BoardMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6001259766243510222L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String boardMessage;

	@ManyToOne
	private BoardUser boardUser;

	@OneToOne
	private Board board;

	public BoardMessage(BoardUser boardUser, Board board, String boardMessage) {
		super();
		this.boardUser = boardUser;
		this.boardMessage = boardMessage;
		this.board = board;
	}

	protected BoardMessage() {

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

	public BoardUser getBoardUser() {
		return boardUser;
	}

	public void setBoardUser(BoardUser boardUser) {
		this.boardUser = boardUser;
	}

	public String getBoardMessage() {
		return boardMessage;
	}

	public void setBoardMessage(String boardMessage) {
		this.boardMessage = boardMessage;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + boardUser + ", message=" + boardMessage + "]";
	}

}

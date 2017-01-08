package com.messageboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messageboard.domain.Board;
import com.messageboard.repo.BoardRepository;

@Service
public class BoardService {

	private BoardRepository boardRepository;

	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public void createBoard(Board board) {
		boardRepository.save(board);
	}

}

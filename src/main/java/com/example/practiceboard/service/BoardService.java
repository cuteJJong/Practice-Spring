package com.example.practiceboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practiceboard.domain.Board;
import com.example.practiceboard.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	//게시글 생성
	public Board createBoard(String title, String content, String writer) {
		Board board = Board.creatBoard(title, content, writer);
		return boardRepository.save(board);
	}

	// 게시글 단일 조회
	public Board getBoard(Long id) {
		return boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 글이 존재하지 않습니다."));
	}

	// 게시글 전체 조회
	public List<Board> getBoardlist() {
		return boardRepository.findAll();
	}

	//수정
	public Board updateBoard(Long id, String title, String content) {
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 글이 존재하지 않습니다."));
		board.update(title, content);
		return boardRepository.save(board);
	}

	//삭제
	public void deleteBoard(Long id) {
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 글이 존재하지 않습니다."));
		boardRepository.delete(board);
	}

}

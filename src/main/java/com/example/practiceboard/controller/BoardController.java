package com.example.practiceboard.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceboard.domain.Board;
import com.example.practiceboard.dto.BoardRequestDto;
import com.example.practiceboard.dto.BoardResponseDto;
import com.example.practiceboard.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	//게시글 생성
	@PostMapping
	public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
		Board board = boardService.createBoard(
				requestDto.getTitle(),
				requestDto.getContent(),
				requestDto.getWriter()
		);
		return new BoardResponseDto(board);
	}

	//게시글 단일 조회
	@GetMapping("/{id}")
	public BoardResponseDto getBoard(@PathVariable long id) {
		Board board = boardService.getBoard(id);
		return new BoardResponseDto(board);
	}

	//게시글 전체 조회
	@GetMapping
	public List<BoardResponseDto> getBoardList() {
		return boardService.getBoardlist().stream()
				.map(BoardResponseDto::new)
				.collect(Collectors.toList());
	}

	// 게시글 수정
	@PutMapping("/update/{id}")
	public BoardResponseDto updateBoard(@PathVariable long id,
			@RequestBody BoardRequestDto requestDto) {
		Board board = boardService.updateBoard(
				id,
				requestDto.getTitle(),
				requestDto.getContent()
		);
		return new BoardResponseDto(board);
	}

	//게시글 삭제
	@DeleteMapping("/{id}")
	public void deleteBoard(@PathVariable long id) {
		boardService.deleteBoard(id);
	}

}

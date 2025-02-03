package com.example.practiceboard.dto;

import com.example.practiceboard.domain.Board;

import lombok.Getter;

@Getter
public class BoardResponseDto {

	private final Long id;

	private final String title;

	private final String content;

	private final String writer;

	// Board 엔티티를 받아서 필요한 정보만 뽑아 DTO에 담는 역할
	public BoardResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.writer = board.getWriter();
	}

}

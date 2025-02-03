package com.example.practiceboard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    // = MySQL의 AUTO_INCREMENT 기능
	private long id;

	private String title;

	private String content;

	private String writer;

	// 게시글 생성을 위한 정적 팩토리 메서드
	public static Board creatBoard(String title, String content, String writer) {
		Board board= new Board();
		board.title = title;
		board.writer = writer;
		board.content = content;
		return board;
	}

	//게시글 수정 메서드
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

}

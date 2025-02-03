package com.example.practiceboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practiceboard.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}

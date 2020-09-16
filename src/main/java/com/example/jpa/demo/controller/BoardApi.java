package com.example.jpa.demo.controller;


import com.example.jpa.demo.application.BoardService;
import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.dto.request.CreateBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/boards")
public class BoardApi {

    private final BoardService boardService;

    @PostMapping(value = "")
    public Board create(@RequestBody CreateBoardDto createBoardDto) {

        log.info("createBoardDto -> {}", createBoardDto);

        return boardService.createBoard(createBoardDto);
    }
}

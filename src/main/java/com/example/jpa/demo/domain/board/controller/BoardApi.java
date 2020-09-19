package com.example.jpa.demo.domain.board.controller;


import com.example.jpa.demo.domain.board.application.BoardService;
import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.dto.BoardDto;
import com.example.jpa.demo.result.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createBoard(@RequestBody final BoardDto.Request createBoardDto) {

        log.info("createBoardDto -> {}", createBoardDto);

        Board board = boardService.createBoard(createBoardDto);

        return ApiResult.ok("팀 생성", board);
    }
}

package com.example.jpa.demo.domain.board.result;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.dto.BoardDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CreateBoardResult {

    @JsonProperty(value = "type")
    private final String type;

    @JsonProperty(value = "board")
    private final BoardDto.Response response;

    private CreateBoardResult(String type, BoardDto.Response response) {
        this.type = type;
        this.response = response;
    }

    public static CreateBoardResult create(String type, Board board) {
        return new CreateBoardResult(type, BoardDto.toJson(board));
    }
}

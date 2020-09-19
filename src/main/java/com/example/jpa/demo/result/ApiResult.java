package com.example.jpa.demo.result;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.result.CreateBoardResult;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.result.CreateTeamResult;
import com.example.jpa.demo.domain.user.result.MyDataResult;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class ApiResult { // extends HashMap<String, Object> {

    public static ResponseEntity<?> ok(String type, Team team) {

        CreateTeamResult createTeamResult = CreateTeamResult.create(type, team);

        return ResponseEntity.ok(createTeamResult);
    }

    public static ResponseEntity<?> ok(String type, Board board) {

        CreateBoardResult createBoardResult = CreateBoardResult.create(type, board);

        return ResponseEntity.ok(createBoardResult);
    }

    public static ResponseEntity<?> ok(List<Team> teams, List<Board> boards) {

        MyDataResult myDataResult = MyDataResult.of(teams, boards);

        return ResponseEntity.ok(myDataResult);
    }


//    public static ResponseEntity<?> ok(Team team) {
//        ApiResult apiResult = ApiResult.empty();
//        apiResult.put("createdBoardResult", TeamDto.Response.toJson(team));
//        return ResponseEntity.ok(apiResult);
//    }

//    public static ResponseEntity<?> ok(Board board) {
//        ApiResult apiResult = ApiResult.empty();
//        apiResult.put("createdBoardResult", board);
//        return ResponseEntity.ok(apiResult);
//    }
//
//    public static ResponseEntity<?> ok(List<Team> teams, List<Board> boards) {
//        ApiResult apiResult = ApiResult.empty();
//
//        List<TeamDto.Response> teamListReponse = TeamDto.Response.toJsonList(teams);
//        List<BoardDto.CreatedResponseDto> boardListResponse = BoardDto.CreatedResponseDto.toJson(boards);
//
//        apiResult.put("myDataResult", MyDataResult.of(teamListReponse, boardListResponse));
//        return ResponseEntity.ok(apiResult);
//    }
}

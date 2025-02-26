package com.example.exam.board;

import com.example.exam.board.model.BoardDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;


    @Operation(summary = "게시글 작성", description = "제목, 작성자, 내용을 입력하여 게시글을 작성하는 기능입니다.")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.CreateReq dto) {
        boardService.register(dto);
        return ResponseEntity.ok("게시글 작성 완료");
    }

    @Operation(summary = "게시글 목록 조회", description = "게시글의 번호, 제목, 작성자, 게시글에 작성된 총 댓글의 수가 출력되는 기능입니다.")
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.ListRes>> getBoardList() {
        List<BoardDto.ListRes> boardList = boardService.getBoardList();
        return ResponseEntity.ok(boardList);
    }

    @Operation(summary = "게시글 상세 조회", description = "게시글 번호로 제목, 내용, 작성자, 댓글 목록을 조회되는 기능입니다.")
    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.DetailRes> getBoardDetail(@PathVariable Long idx) {
        BoardDto.DetailRes boardDetail = boardService.getBoardDetail(idx);
        return ResponseEntity.ok(boardDetail);
    }
}

package com.example.exam.board;

import com.example.exam.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.CreateReq dto) {
        boardService.register(dto);
        return ResponseEntity.ok("게시글 작성 완료");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.ListRes>> getBoardList() {
        List<BoardDto.ListRes> boardList = boardService.getBoardList();
        return ResponseEntity.ok(boardList);
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.DetailRes> getBoardDetail(@PathVariable Long idx) {
        BoardDto.DetailRes boardDetail = boardService.getBoardDetail(idx);
        return ResponseEntity.ok(boardDetail);
    }
}

package com.example.exam.board;

import com.example.exam.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService BoardService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.CreateReq dto) {
        BoardService.register(dto);
        return ResponseEntity.ok("게시글 작성 완료");
    }
}

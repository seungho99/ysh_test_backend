package com.example.exam.comment;

import com.example.exam.comment.model.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "댓글 작성", description = "게시글에 내용, 작성자를 입력하여 댓글을 등록하는 기능입니다.")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CommentDto.CreateReq dto) {
        commentService.register(dto);
        return ResponseEntity.ok("댓글 작성 완료");
    }
}

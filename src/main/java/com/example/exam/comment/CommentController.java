package com.example.exam.comment;

import com.example.exam.comment.model.CommentDto;
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

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CommentDto.CreateReq dto) {
        commentService.register(dto);
        return ResponseEntity.ok("댓글 작성 완료");
    }
}

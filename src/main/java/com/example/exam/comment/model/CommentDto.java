package com.example.exam.comment.model;

import com.example.exam.board.model.Board;
import lombok.Getter;

public class CommentDto {
    @Getter
    public static class CreateReq {
        private String content;
        private String writer;

        public Comment toEntity() {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }
}

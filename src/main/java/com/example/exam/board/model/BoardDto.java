package com.example.exam.board.model;

import com.example.exam.comment.model.Comment;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {

    @Getter
    public static class CreateReq {
        private String title;
        private String content;
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter
    public static class ListRes {
        private Long idx;
        private String title;
        private String writer;
        private int commentCount;

        public ListRes(Board board) {
            this.idx = board.getIdx();
            this.title = board.getTitle();
            this.writer = board.getWriter();
            this.commentCount = board.getCommentList().size();
        }
    }

    @Getter
    public static class DetailRes {
        private String title;
        private String content;
        private String writer;
        private List<String> comments;

        public DetailRes(Board board) {
            this.title = board.getTitle();
            this.content = board.getContent();
            this.writer = board.getWriter();
            this.comments = board.getCommentList().stream()
                    .map(Comment::getContent)
                    .collect(Collectors.toList());
        }
    }
}

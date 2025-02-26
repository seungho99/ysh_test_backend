package com.example.exam.board.model;

import com.example.exam.comment.model.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {

    @Getter
    public static class CreateReq {
        @Schema(description = "게시글 제목", example = "한화시스템 부트캠프 회고")
        private String title;
        @Schema(description = "게시글 내용", example = "강사님 짱~!")
        private String content;
        @Schema(description = "작성자", example = "12기 홍길동")
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
        @Schema(description = "게시글 번호", example = "1")
        private Long idx;
        @Schema(description = "게시글 제목", example = "한화시스템 부트캠프 회고")
        private String title;
        @Schema(description = "게시글 내용", example = "강사님 짱~!")
        private String writer;
        @Schema(description = "총 댓글 수", example = "4")
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
        @Schema(description = "게시글 제목", example = "한화시스템 부트캠프 회고")
        private String title;
        @Schema(description = "게시글 내용", example = "강사님 짱~!")
        private String content;
        @Schema(description = "작성자", example = "12기 홍길동")
        private String writer;
        @Schema(description = "댓글 목록")
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

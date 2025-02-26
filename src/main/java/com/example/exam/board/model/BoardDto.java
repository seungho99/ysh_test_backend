package com.example.exam.board.model;

import lombok.Getter;

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
}

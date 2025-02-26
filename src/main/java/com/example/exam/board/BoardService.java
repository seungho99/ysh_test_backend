package com.example.exam.board;

import com.example.exam.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;


    public void register(BoardDto.CreateReq dto) {
        boardRepository.save(dto.toEntity());
    }
}

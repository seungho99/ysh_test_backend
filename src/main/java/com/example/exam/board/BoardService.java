package com.example.exam.board;

import com.example.exam.board.model.Board;
import com.example.exam.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.CreateReq dto) {
        boardRepository.save(dto.toEntity());
    }

    public List<BoardDto.ListRes> getBoardList() {
        return boardRepository.findAll()
                .stream()
                .map(BoardDto.ListRes::new)
                .collect(Collectors.toList());
    }

    public BoardDto.DetailRes getBoardDetail(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        return new BoardDto.DetailRes(board);
    }
}

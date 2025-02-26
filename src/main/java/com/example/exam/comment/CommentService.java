package com.example.exam.comment;

import com.example.exam.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public void register(CommentDto.CreateReq dto) {
        commentRepository.save(dto.toEntity());
    }
}

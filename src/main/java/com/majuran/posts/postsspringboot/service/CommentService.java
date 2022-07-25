package com.majuran.posts.postsspringboot.service;

import com.majuran.posts.postsspringboot.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto save(CommentDto commentDto);

    boolean delete(Long commentId);

    List<CommentDto> getAll();

    CommentDto getById(Long postId);
}

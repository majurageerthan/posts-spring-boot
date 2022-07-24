package com.majuran.posts.postsspringboot.service;

import com.majuran.posts.postsspringboot.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto save(AuthorDto authorDto);

    boolean delete(Long authorId);

    List<AuthorDto> getAll();

    AuthorDto getById(Long authorId);
}

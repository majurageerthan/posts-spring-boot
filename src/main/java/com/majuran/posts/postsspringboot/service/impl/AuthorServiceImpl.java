package com.majuran.posts.postsspringboot.service.impl;

import com.majuran.posts.postsspringboot.dto.AuthorDto;
import com.majuran.posts.postsspringboot.entity.Author;
import com.majuran.posts.postsspringboot.repository.AuthorRepository;
import com.majuran.posts.postsspringboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        Author author = populateToAuthor(authorDto);
        return populateToAuthorDto(authorRepository.save(author));
    }

    @Override
    public boolean delete(Long authorId) {
        authorRepository.deleteById(authorId);
        return true;
    }

    @Override
    public List<AuthorDto> getAll() {
        List<AuthorDto> authors = new ArrayList<>();
        List<Author> authorList = authorRepository.findAll();
        authorList.forEach(author -> authors.add(populateToAuthorDto(author)));
        return authors;
    }

    @Override
    public AuthorDto getById(Long id) {
        return populateToAuthorDto(authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found")));
    }

    private AuthorDto populateToAuthorDto(final Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setEmail(author.getEmail());
        authorDto.setUsername(author.getUsername());
        authorDto.setAddress(author.getAddress());
        return authorDto;
    }

    private Author populateToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());
        author.setUsername(authorDto.getUsername());
        author.setAddress(authorDto.getAddress());
        return author;
    }
}
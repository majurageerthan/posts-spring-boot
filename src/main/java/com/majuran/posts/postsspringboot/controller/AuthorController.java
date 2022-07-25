package com.majuran.posts.postsspringboot.controller;

import com.majuran.posts.postsspringboot.dto.AuthorDto;
import com.majuran.posts.postsspringboot.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Resource(name = "authorService")
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/author/{id}")
    public AuthorDto geyAuthor(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PostMapping("/author")
    public AuthorDto saveAuthor(final @RequestBody AuthorDto postDto) {
        return authorService.save(postDto);
    }

    @PutMapping("/author")
    public AuthorDto updateAuthor(final @RequestBody AuthorDto postDto) {
        return authorService.save(postDto);
    }

    @DeleteMapping("/author/{id}")
    public Boolean deleteAuthor(@PathVariable Long id) {
        return authorService.delete(id);
    }

}
package com.majuran.posts.postsspringboot.controller;

import com.majuran.posts.postsspringboot.dto.CommentDto;
import com.majuran.posts.postsspringboot.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Resource(name = "commentService")
    private CommentService commentService;

    @GetMapping
    public List<CommentDto> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/comment/{id}")
    public CommentDto geyComment(@PathVariable Long id) {
        return commentService.getById(id);
    }

    @PostMapping("/comment")
    public CommentDto saveComment(final @RequestBody CommentDto commentDto) {
        return commentService.save(commentDto);
    }

    @PutMapping("/comment")
    public CommentDto updateComment(final @RequestBody CommentDto commentDto) {
        return commentService.save(commentDto);
    }

    @DeleteMapping("/comment/{id}")
    public Boolean deleteComment(@PathVariable Long id) {
        return commentService.delete(id);
    }

}
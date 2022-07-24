package com.majuran.posts.postsspringboot.controller;

import com.majuran.posts.postsspringboot.dto.PostDto;
import com.majuran.posts.postsspringboot.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Resource(name = "postService")
    private PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public PostDto geyPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/post")
    public PostDto savePost(final @RequestBody PostDto postDto) {
        return postService.savePost(postDto);
    }

    @PutMapping("/post")
    public PostDto updatePost(final @RequestBody PostDto postDto) {
        return postService.savePost(postDto);
    }

    @DeleteMapping("/post/{id}")
    public Boolean deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}
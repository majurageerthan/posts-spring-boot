package com.majuran.posts.postsspringboot.service;

import com.majuran.posts.postsspringboot.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);

    boolean deletePost(Long postId);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long postId);
}

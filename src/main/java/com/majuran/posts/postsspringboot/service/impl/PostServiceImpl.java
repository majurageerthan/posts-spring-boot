package com.majuran.posts.postsspringboot.service.impl;

import com.majuran.posts.postsspringboot.dto.PostDto;
import com.majuran.posts.postsspringboot.entity.Post;
import com.majuran.posts.postsspringboot.repository.PostRepository;
import com.majuran.posts.postsspringboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto savePost(PostDto postDto) {
        Post post = populateToPost(postDto);
        return populateToPostDto(postRepository.save(post));
    }

    @Override
    public boolean deletePost(Long postId) {
        postRepository.deleteById(postId);
        return true;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> posts = new ArrayList<>();
        List<Post> postList = postRepository.findAll();
        postList.forEach(post -> posts.add(populateToPostDto(post)));
        return posts;
    }

    @Override
    public PostDto getPostById(Long postId) {
        return populateToPostDto(postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found")));
    }

    private PostDto populateToPostDto(final Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setBody(post.getBody());
        postDto.setAuthorId(post.getAuthorId());
        postDto.setCreatedOn(post.getCreatedOn());
        postDto.setModifiedOn(post.getModifiedOn());
        return postDto;
    }

    private Post populateToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setAuthorId(postDto.getAuthorId());
        post.setCreatedOn(postDto.getCreatedOn());
        post.setModifiedOn(postDto.getModifiedOn());
        return post;
    }
}
package com.majuran.posts.postsspringboot.service.impl;

import com.majuran.posts.postsspringboot.dto.CommentDto;
import com.majuran.posts.postsspringboot.entity.Comment;
import com.majuran.posts.postsspringboot.entity.Post;
import com.majuran.posts.postsspringboot.repository.CommentRepository;
import com.majuran.posts.postsspringboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentDto save(CommentDto commentDto) {
        Comment comment = populateToComment(commentDto);
        return populateToCommentDto(commentRepository.save(comment));
    }

    @Override
    public boolean delete(Long postId) {
        commentRepository.deleteById(postId);
        return true;
    }

    @Override
    public List<CommentDto> getAll() {
        List<CommentDto> comments = new ArrayList<>();
        List<Comment> commentList = commentRepository.findAll();
        commentList.forEach(comment -> comments.add(populateToCommentDto(comment)));
        return comments;
    }

    @Override
    public CommentDto getById(Long id) {
        return populateToCommentDto(commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found")));
    }

    private CommentDto populateToCommentDto(final Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        commentDto.setPostId(comment.getPost().getId());
        commentDto.setCreatedOn(comment.getCreatedOn());
        commentDto.setModifiedOn(comment.getModifiedOn());
        return commentDto;
    }

    private Comment populateToComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        comment.setPost(new Post(commentDto.getPostId()));
        comment.setCreatedOn(commentDto.getCreatedOn());
        comment.setModifiedOn(commentDto.getModifiedOn());
        return comment;
    }
}
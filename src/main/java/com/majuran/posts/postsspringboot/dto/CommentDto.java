package com.majuran.posts.postsspringboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;
    private Long postId;
    private Date createdOn;
    private Date modifiedOn;
}

package com.majuran.posts.postsspringboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private int authorId;
    private Date createdOn;
    private Date modifiedOn;
}

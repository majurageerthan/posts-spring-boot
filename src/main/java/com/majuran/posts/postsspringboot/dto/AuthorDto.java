package com.majuran.posts.postsspringboot.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;
}

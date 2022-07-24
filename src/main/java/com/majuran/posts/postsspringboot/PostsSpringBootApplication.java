package com.majuran.posts.postsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PostsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostsSpringBootApplication.class, args);
    }

}

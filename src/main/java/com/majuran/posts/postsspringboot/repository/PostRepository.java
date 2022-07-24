package com.majuran.posts.postsspringboot.repository;

import com.majuran.posts.postsspringboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> { }

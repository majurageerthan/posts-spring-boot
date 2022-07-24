package com.majuran.posts.postsspringboot.repository;

import com.majuran.posts.postsspringboot.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

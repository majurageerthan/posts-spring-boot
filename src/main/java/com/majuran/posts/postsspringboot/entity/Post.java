package com.majuran.posts.postsspringboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String body;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private Author author;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date createdOn;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date modifiedOn;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

}

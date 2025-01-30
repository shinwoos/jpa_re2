package com.example.jpa_re2.domain.post.post.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id // PRIMARY_KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
}

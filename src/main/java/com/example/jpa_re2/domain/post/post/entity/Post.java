package com.example.jpa_re2.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Post {

    @Id // PRIMARY_KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id; // long -> null X, Ling -> null O
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
}

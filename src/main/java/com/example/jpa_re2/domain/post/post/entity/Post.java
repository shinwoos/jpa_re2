package com.example.jpa_re2.domain.post.post.entity;

import com.example.jpa_re2.domain.post.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id // PRIMARY_KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Setter(AccessLevel.PRIVATE)
    private Long id; // long -> null X, Ling -> null O

    @CreatedDate
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime modifiedDate;

    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

}

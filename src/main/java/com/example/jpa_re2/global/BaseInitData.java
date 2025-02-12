package com.example.jpa_re2.global;

import com.example.jpa_re2.domain.post.comment.entity.Comment;
import com.example.jpa_re2.domain.post.comment.service.CommentService;
import com.example.jpa_re2.domain.post.post.entity.Post;
import com.example.jpa_re2.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    @Lazy
    private BaseInitData self; // 프록시

    @Bean
    @Order(1)
    public ApplicationRunner applicationRunner() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1(){

        if (postService.count() > 0) {
            return;
        }

        Post p1 = postService.write("title1", "body1");

        Comment c1 = Comment.builder()
                .body("comment1")
                .build();

        p1.getComments().add(c1);

        commentService.write(p1, "comment1");

    }

}


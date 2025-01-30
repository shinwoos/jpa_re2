package com.example.jpa_re2.global;

import com.example.jpa_re2.domain.post.post.entity.Post;
import com.example.jpa_re2.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    public ApplicationRunner applicationRunner(){
        return  args -> {

            if(postService.count() > 0){
                return;
            }

            Post p1 = postService.write("title1", "body1");
            System.out.println(p1.getId() + "번 포스트가 생성");

            Post p2 = postService.write("title1", "body1");
            System.out.println(p2.getId() + "번 포스트가 생성");

            Post p3 = postService.write("title1", "body1");
            System.out.println(p3.getId() + "번 포스트가 생성");
        };
    }
}

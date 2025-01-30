package com.example.jpa_re2.global;

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

            postService.write("title1", "body1");
            postService.write("title1", "body1");
            postService.write("title1", "body1");

        };
    }
}

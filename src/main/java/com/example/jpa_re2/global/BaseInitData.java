package com.example.jpa_re2.global;

import com.example.jpa_re2.domain.post.comment.entity.Comment;
import com.example.jpa_re2.domain.post.comment.service.CommentService;
import com.example.jpa_re2.domain.post.post.entity.Post;
import com.example.jpa_re2.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;
    private final CommentService commentService;

    @Bean
    @Order(1)
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

    @Bean
    @Order(2)
    public ApplicationRunner applicationRunner2(){
        return  args -> {

            Post post = postService.findById(1L).get();
            Comment c1 = commentService.write(post.getId(), "comment1");
            Comment c2 = commentService.write(post.getId(), "comment2");
            Comment c3 = commentService.write(post.getId(), "comment3");

            //번 게시글 댓글


        };
    }


//
//    @Bean
//    @Order(3)
//    public  ApplicationRunner applicationRunner3(){
//        return new ApplicationRunner() {
//            @Override
//            @Transactional
//            public void run(ApplicationArguments args) throws Exception {
//                Post p1 = postService.findById(1L).get();
//                Post p2 = postService.findById(2L).get();
//
//                System.out.println("====== p1 삭제 ======");
//                postService.delete(p1);
//                System.out.println("====== p1 삭제 완료 ======");
//
//                System.out.println("====== p2 삭제 ======");
//                postService.delete(p2);
//                System.out.println("====== p2 삭제 완료 ======");
//            }
//        };
//    }
//
//    @Bean
//    @Order(4)
//    public  ApplicationRunner applicationRunner4(){
//        return new ApplicationRunner() {
//            @Override
//            @Transactional
//            public void run(ApplicationArguments args) throws Exception {
//                Post post = postService.findById(3L).get();
//                System.out.println(post.getId() + "번 포스트를 가져왔습니다.");
//
//                System.out.println("====================================");
//
//                Post post2 = postService.findById(3L).get();
//                System.out.println(post.getId() + "번 포스트를 가져왔습니다.");
//            }
//        };
//    }
}

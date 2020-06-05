package com.metamong.commonweb.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable("id") Post post) {
        // DomainClassConverter 에서 아래 과정을 해준다 ..!
//        Optional<Post> byId = postRepository.findById(id);
//        Post post = byId.get();

        return post.getTitle();
    }
}

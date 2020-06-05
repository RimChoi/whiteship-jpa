package com.metamong.commonweb.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository posts;

    @GetMapping("/posts/{id}")
    public String getPosts(@PathVariable("id") Post post) {
        // DomainClassConverter 에서 아래 과정을 해준다 ..!
//        Optional<Post> byId = postRepository.findById(id);
//        Post post = byId.get();

        return post.getTitle();
    }

    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable) {
        return posts.findAll(pageable);
    }
}

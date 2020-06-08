package com.metamong.commonweb.comment;


import com.metamong.commonweb.post.Post;
import com.metamong.commonweb.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.metamong.commonweb.comment.CommentSpecs.isGood;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    Post savedPost = null;

    @Test
    public void getComment() {
        createMockComment();

        commentRepository.getById(1l);
        System.out.println("================================");

        Optional<Comment> byId = commentRepository.findById(1l);

    }

    private Comment createMockComment() {
        Post post = new Post();
        post.setTitle("jpa");
        savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("comment");
        comment.setUp(10);
        comment.setDown(1);
        comment.setPost(savedPost);

        return commentRepository.save(comment);
    }

    @Test
    public void getComment2() {
        Comment comment = this.createMockComment();

        commentRepository.findByPost_Id(savedPost.getId(), CommentOnly.class).forEach(c -> {
            System.out.println("================");
//            System.out.println(c.getVotes());
            System.out.println(c.getComment());
        });
    }

    @Test
    public void specs() {
        commentRepository.findAll(CommentSpecs.isBest().or(isGood()), PageRequest.of(0, 10) );
    }

    @Test
    public void qbe() {
        Comment probe = new Comment();
        probe.setBest(true);

        ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnorePaths("up", "down");
        Example<Comment> example = Example.of(probe, matcher);
        commentRepository.findAll(example);
    }
}
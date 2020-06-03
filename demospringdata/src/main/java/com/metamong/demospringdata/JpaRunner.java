package com.metamong.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Session session = entityManager.unwrap(Session.class);

//        Post post = new Post();
//        post.setTitle("Spring Data JPA ..");
//
//        Comment comment = new Comment();
//        comment.setComment("언제 다보나 ..");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment.setComment("금방 보겠지..?");
//        post.addComment(comment1);

//        session.save(post);

        Post post = session.get(Post.class, 1l);
        session.delete(post);
    }
}

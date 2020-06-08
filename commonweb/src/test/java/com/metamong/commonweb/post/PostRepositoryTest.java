package com.metamong.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post); // insert (persist)

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(post == savedPost);

        Post updatePost = new Post();
        updatePost.setTitle("hibernate");
        updatePost.setId(post.getId());
        Post updatedPost = postRepository.save(updatePost); // update (merge)

        // 코딩습관 !! 리턴 받은 인스턴스를 사용하자 ..
        // e.g. updatePost (x) updatedPost (o)
        updatedPost.setTitle("metamong");

        assertThat(entityManager.contains(updatePost)).isFalse();
        assertThat(entityManager.contains(updatedPost)).isTrue();
        assertThat(updatePost != updatedPost);

        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void findByTitle() {
        savePost();

//        List<Post> all = postRepository.findByTitle("Spring", Sort.by("title"));
        List<Post> all = postRepository.findByTitle("Spring", JpaSort.unsafe("LENGTH(title)"));
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void updateTitle() {
        Post spring = savePost();
        String hibernate = "hibernate";


//        int update = postRepository.updateTitle(hibernate, spring.getId());
//        assertThat(update).isEqualTo(1);
//
//        Optional<Post> byId = postRepository.findById(spring.getId());
//        Post post = byId.get();
//        assertThat(post.getTitle()).isEqualTo(hibernate);


        // hibernate 가 find 하기전에 DB Sync 를 맞춘다.
        spring.setTitle(hibernate);
        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo("hibernate");
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");

        return postRepository.save(post);
    }

}
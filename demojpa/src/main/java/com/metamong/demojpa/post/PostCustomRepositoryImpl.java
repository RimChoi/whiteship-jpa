package com.metamong.demojpa.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository<Post> {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post> findVyPost() {
        System.out.println("custom findMyPost");
        return entityManager.createQuery("SELECT p from Post as p", Post.class).getResultList();
    }

    @Override
    public void delete(Post entity) {
        System.out.println("custom delete");
        entityManager.remove(entity);
    }

}

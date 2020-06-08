package com.metamong.demojpa.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findVyPost();

    void delete(T entity);
}

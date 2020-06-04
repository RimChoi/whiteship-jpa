package com.metamong.demojpa.post;

import com.metamong.demojpa.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends MyRepository<Post, Long> {

}

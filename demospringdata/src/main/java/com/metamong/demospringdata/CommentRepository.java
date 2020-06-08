package com.metamong.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)

public interface CommentRepository extends JpaRepository<Comment, Long> {

//    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

//    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

//    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

//    Future<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    /**
     * Asynchronous.. Background 에서 동작하는 Thread-pool 에 메서드 실행 작업을 위임하는 것
     * @param keyword
     * @return
     */
    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}

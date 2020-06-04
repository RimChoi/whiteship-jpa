package com.metamong.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)

public interface CommentRepository extends MyRepository<Comment, Long> {

//    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

//    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}

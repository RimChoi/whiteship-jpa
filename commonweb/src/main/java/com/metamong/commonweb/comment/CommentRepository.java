package com.metamong.commonweb.comment;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>,
        JpaSpecificationExecutor<Comment>, QueryByExampleExecutor<Comment> {

    @EntityGraph(
//            value = "Comment.post"
            attributePaths = "post"
    )
    Optional<Comment> getById(Long id);

//    List<Comment> findByPost_Id(Long id);
//    List<CommentSummary> findByPost_Id(Long id);
    <T> List<T> findByPost_Id(Long id, Class<T> type);
}

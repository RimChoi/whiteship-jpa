package com.metamong.demospringdata;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {
    <E extends T> E save(@NonNull E Entity);

    List<T> findAll();

    long count();

    // 단일 값을 적용할 때, Optional을 잘 써보자
    @Nullable
    <E extends T> Optional<E> findById(Id id);
}

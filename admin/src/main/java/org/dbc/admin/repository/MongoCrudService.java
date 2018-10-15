package org.dbc.admin.repository;

import org.dbc.admin.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/9 15:52
 */
public interface MongoCrudService<T, ID extends Serializable> {
    boolean exists(ID var1);

    long count();

    long count(Query var1);

    long count(T var1);

    T findById(ID var1);

    T findOne(Query var1);

    T findOne(T var1);

    List<T> findAll();

    Page<T> find(Pageable var1);

    List<T> find(Query var1);

    List<T> find(T var1);

    Page<T> find(Query var1, Pageable var2);

    Page<T> find(T var1, Pageable var2);

    T insert(T var1);

    List<T> insertAll(List<T> var1);

    T update(T var1);

    List<T> updateAll(List<T> var1);

    void delete(ID var1);

    void delete(T var1);

    void deleteAll();
}


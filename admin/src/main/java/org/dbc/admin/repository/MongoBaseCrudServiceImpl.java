package org.dbc.admin.repository;

import lombok.extern.slf4j.Slf4j;
import org.dbc.admin.domain.Sequence;
import org.dbc.admin.enums.Constants;
import org.dbc.admin.repository.MongoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/9 15:56
 */
public abstract class MongoBaseCrudServiceImpl<T, ID extends Serializable> implements MongoCrudService<T, ID> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private Class<T>        modelClass;

    @SuppressWarnings("unchecked")
    public MongoBaseCrudServiceImpl() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        this.modelClass = (Class<T>) typeArguments[0];
    }

    @Override
    public boolean exists(ID id) {
        Objects.requireNonNull(id, "The given id must not be null!");
        Object result = mongoTemplate.findById(id, this.modelClass);
        return result != null ? true : false;
    }

    @Override
    public long count() {
        return mongoTemplate.count(null, this.modelClass);
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, this.modelClass);
    }

    @Override
    public long count(T entity) {
        if (entity == null) {
            return 0L;
        }
        return this.count(new Query(Criteria.byExample(entity)));
    }

    @Override
    public T findById(ID id) {
        return mongoTemplate.findById(id, this.modelClass);
    }

    @Override
    public T findOne(Query query) {
        List<T> list = this.find(query);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public T findOne(T entity) {
        if (entity == null) {
            return null;
        }
        return this.findOne(new Query(Criteria.byExample(entity)));
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(this.modelClass);
    }

    @Override
    public Page<T> find(Pageable pageable) {
        List<T> list = mongoTemplate.find(new Query().with(pageable), this.modelClass);
        return new PageImpl<T>(list, pageable, this.count());
    }

    @Override
    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.modelClass);
    }

    @Override
    public List<T> find(T entity) {
        if (entity == null) {
            return null;
        }
        return this.find(new Query(Criteria.byExample(entity)));
    }

    @Override
    public Page<T> find(Query query, Pageable pageable) {
        query.with(pageable);
        List<T> list = this.find(query);
        return new PageImpl<T>(list, pageable, this.count(query));
    }

    @Override
    public Page<T> find(T entity, Pageable pageable) {
        if (entity == null) {
            return null;
        }
        return this.find(new Query(Criteria.byExample(entity)), pageable);
    }

    @Override
    public T insert(T entity) {
        Objects.requireNonNull(entity, "Entity must not be null!");
        mongoTemplate.insert(entity);
        return entity;
    }

    @Override
    public List<T> insertAll(List<T> list) {
        Objects.requireNonNull(list, "The given Iterable of entities not be null!");
        if (list.isEmpty()) {
            return list;
        }
        mongoTemplate.insertAll(list);
        return list;
    }

    @Override
    public T update(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    public List<T> updateAll(List<T> list) {
        Objects.requireNonNull(list, "The given Iterable of entities not be null!");
        for (T entity : list) {
            update(entity);
        }
        return list;
    }

    @Override
    public void delete(ID id) {
        mongoTemplate.remove(findById(id));
    }

    @Override
    public void delete(T entity) {
        mongoTemplate.remove(entity);
    }

    @Override
    public void deleteAll() {
        mongoTemplate.remove(new Query(), this.modelClass);
    }


    /**
     * 获取项目自增ID
     */
    protected Long getNextId(String code) {
        Query query = new Query(Criteria.where(Sequence.FIELD_APP_ID).is(Constants.FIELD_ROBOT_SERVER_APP_ID).
                and(Sequence.FIELD_ROBOT_ID).is(Constants.FIELD_ROBOT_SERVER_ROBOT_ID).
                and(Sequence.FIELD_PROJECT_CODE).is(code));

        Update update = new Update();
        update.inc(Sequence.FIELD_SEQ_ID, 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);

        Sequence seqId = mongoTemplate.findAndModify(query, update, options, Sequence.class);
        return seqId.getSeqId();
    }
}

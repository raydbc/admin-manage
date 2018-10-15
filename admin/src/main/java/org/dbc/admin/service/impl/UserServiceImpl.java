package org.dbc.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.dbc.admin.domain.User;
import org.dbc.admin.repository.MongoBaseCrudServiceImpl;
import org.dbc.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/10 17:41
 */
@Service
public class UserServiceImpl extends MongoBaseCrudServiceImpl<User, String> implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findByEmail(String emailEncryption) {
        if (StringUtils.isEmpty(emailEncryption.trim())) return null;
//        findOne(new Query(Criteria.where(User.FIELD_EMAIL).is(emailEncryption.trim()).and(User.FIELD_ACTIVATED).is(true)));
        Query query = new Query(Criteria.where(User.FIELD_EMAIL).is(emailEncryption).and(User.FIELD_ACTIVATED).is(true));

       return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public List<User> findAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public long getCount() {
        Query query = new Query(Criteria.where(User.FIELD_ACTIVATED).is(true));
        return  mongoTemplate.count(query, User.class);
    }
}

package org.dbc.admin.service;

import org.dbc.admin.domain.User;
import org.dbc.admin.repository.MongoCrudService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/9 15:52
 */

public interface UserService {

    /**
     * 通过email 查找用户
     * @param email
     * @return
     */
    User findByEmail(String email);

    List<User> findAllUsers();

    long getCount();
}
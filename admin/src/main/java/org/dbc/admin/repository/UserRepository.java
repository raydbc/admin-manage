package org.dbc.admin.repository;

import org.dbc.admin.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/10 17:38
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
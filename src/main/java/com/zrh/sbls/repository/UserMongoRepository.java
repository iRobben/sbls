package com.zrh.sbls.repository;

import com.zrh.sbls.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
public interface UserMongoRepository extends MongoRepository<User,String> {

}

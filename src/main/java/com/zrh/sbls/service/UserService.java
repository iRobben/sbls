package com.zrh.sbls.service;

import com.zrh.sbls.model.User;

import java.util.List;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
public interface UserService {

    void save(User user);

    void delete(User user);

    List<User> findAll();
}

package com.zrh.sbls.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrh.sbls.repository.UserMongoRepository;
import com.zrh.sbls.model.User;
import com.zrh.sbls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMongoRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);

    }


    @Override
    public List<User> findAll() {
       return userRepository.findAll();

    }
}

package com.zrh.sbls.service.impl;

import com.zrh.sbls.model.User;
import com.zrh.sbls.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setId(1000L);
        user.setUsername("zhangrenhuatest");
        user.setMobile("13477083078");
        user.setPassword(passwordEncoder.encode("m123456"));
        userService.save(user);
        List<User> all = userService.findAll();
        System.out.println(all);


    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }




}
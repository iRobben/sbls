package com.zrh.sbls.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.zrh.sbls.service.DemoService;


@Service
public class DemoServiceImpl implements DemoService {


    public String sayName(String name) {
        return "zrh";
    }
}
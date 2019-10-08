package com.zrh.sbls.service.impl;

import com.zrh.sbls.service.ISpiService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/9/6
 */
public class BSpiServiceImpl implements ISpiService {
    @Override
    public String execute() {
        return "service b";
    }

    public static void main(String[] args) {

        ServiceLoader<ISpiService> spiServices = ServiceLoader.load(ISpiService.class);
        Iterator<ISpiService> iterator = spiServices.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().execute());
        }

    }
}

package com.zrh.sbls.service.impl;

import com.zrh.sbls.model.UmsAdmin;
import com.zrh.sbls.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UmsAdminServiceImplTest {

    @Autowired
    private UmsAdminService umsAdminService;

    @Test
    public void search() throws Exception {
        Page<UmsAdmin> admin = umsAdminService.search("测试", 0, 10);
        System.out.print(admin);
    }

    @Test
    public void importData() throws Exception {
        umsAdminService.importData();
    }

}
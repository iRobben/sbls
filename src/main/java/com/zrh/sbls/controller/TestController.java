package com.zrh.sbls.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrh.sbls.common.CommonResult;
import com.zrh.sbls.model.UmsAdmin;
import com.zrh.sbls.service.DemoService;
import com.zrh.sbls.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * test
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/7/26
 */
@Api(tags = "testModule", description = "测试模块")
@RestController
public class TestController {

    @Reference
    private DemoService demoService;

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("测试接口")
    @GetMapping("test")
    public CommonResult test(){
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername("admin");
        String name = demoService.sayName("hello");
        umsAdmin.setUsername(name);
        throw new RuntimeException("test Exception");
       // return CommonResult.success(umsAdmin);

    }



}

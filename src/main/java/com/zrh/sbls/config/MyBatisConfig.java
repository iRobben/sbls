package com.zrh.sbls.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/7/26
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.zrh.sbls.dao")
public class MyBatisConfig {
}

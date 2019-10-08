package com.zrh.sbls.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
@NacosPropertySource(dataId = "redis.properties")
public class RedisConfig {


    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.pwd}")
    private String password;

    @Value("${redis.timeout}")
    private int timeout;

    @Value("${redis.maxWaitMillis}")
    private int maxWaitMillis;

    @Value("${redis.minIdle}")
    private int minIdle;

    @Value("${redis.maxIdle}")
    private int maxIdle;

    @Value("${redis.maxTotal}")
    private int maxTotal;



    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        JedisPoolConfig config = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        // 最多空闲的链接 默认=8
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(maxWaitMillis);
        //设置为false表明，在获取连接和释放连接时，不再检测Jedis与Redis之间连接是否正常
        //获取连接时是否触发ping-消耗性能增加CPU和网络开销
        config.setTestOnBorrow(false);
        //释放连接时是否触发ping-消耗性能增加CPU和网络开销
        config.setTestOnReturn(false);
        //空闲连接扫描时，每次最多扫描的连接数,一般设置为-1，全部扫描
        config.setNumTestsPerEvictionRun(-1);
        //连接在池中保持空闲而不被空闲连接回收器线程回收的最小时间值,单位毫秒
        config.setMinEvictableIdleTimeMillis(120000);
        //每隔60秒定期检查空闲连接
        config.setTimeBetweenEvictionRunsMillis(60000);
        log.info("链接redis " + host + " : " + port);
        if(StringUtils.isNotBlank(password)) {
            return new JedisPool(config, host, port, timeout, password);
        } else {
            return new JedisPool(config, host, port, timeout);
        }
    }


}
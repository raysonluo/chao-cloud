package com.chao.cloud.common.support.mybatis.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chao.cloud.common.support.mybatis.locker.interceptor.OptimisticLockerInterceptor;

@Configuration
public class MybatisPluginsConfig {
    /**
     * 乐观锁 插件
     * 
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLoker() {
        return new OptimisticLockerInterceptor();
    }

}

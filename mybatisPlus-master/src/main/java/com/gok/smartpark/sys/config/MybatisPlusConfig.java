package com.gok.smartpark.sys.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页拦截器
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
}

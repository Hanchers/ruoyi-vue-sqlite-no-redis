package com.ruoyi.framework.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisFlexConfig {

    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";


    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }
}

package com.ruoyi.framework.config;

import com.github.pagehelper.PageInterceptor;
import com.mybatisflex.spring.boot.ConfigurationCustomizer;
import com.ruoyi.framework.config.typehandler.DateStringTypeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MybatisFlexConfig {

    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    /**
     * 注册 Date -> 格式化日期字符串的 TypeHandler
     * 解决 SQLite 中 Date 被存储为整型时间戳的问题，
     * 使 Date 字段统一以 "yyyy-MM-dd HH:mm:ss" 格式存储和读取
     */
    @Bean
    public ConfigurationCustomizer dateTypeHandlerCustomizer() {
        return configuration -> configuration.getTypeHandlerRegistry()
                .register(Date.class, new DateStringTypeHandler());
    }
}

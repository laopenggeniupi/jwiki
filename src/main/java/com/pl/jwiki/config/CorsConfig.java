package com.pl.jwiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
解决跨域问题
 */
//@Configuration注解将 CorsConfig 类标记为 Spring 的配置类，Spring 容器会自动扫描并加载这个配置类。
//CorsConfig 类实现了 WebMvcConfigurer接口，并重写了 addCorsMappings 方法。
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置允许跨域的路径
        registry.addMapping("/**")
                // 允许所有的请求域名访问该跨域资源服务器
                .allowedOriginPatterns("*")
                // 允许任何请求头
                .allowedHeaders(CorsConfiguration.ALL)
                // 允许任何请求方法
                .allowedMethods(CorsConfiguration.ALL)
                // 允许携带凭证（如cookie）
                .allowCredentials(true)
                // 1小时内不需要再预检（发OPTIONS请求）
                .maxAge(3600);
    }

}

package com.octopus.config;

import com.octopus.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    static final private String FAVICON_URL = "/favicon.ico";


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new AuthenticationInterceptor()
        ).addPathPatterns("/**").excludePathPatterns(FAVICON_URL);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}

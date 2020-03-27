package com.shiyanlou.mall.config;/**
 * @Author jettx
 * @Date 3/24/2020 11:23 AM
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jettx
 * @date 3/24/2020 11:23 AM
 */
@Configuration
public class SpringbootWebMvcConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file:C:\\upload\\");
    }
}

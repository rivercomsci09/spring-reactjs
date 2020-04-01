package com.river.devicesmanagement.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SpringConfigure implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/view/react/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("/WEB-INF/view/react/build/index.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:5000");
    }
}

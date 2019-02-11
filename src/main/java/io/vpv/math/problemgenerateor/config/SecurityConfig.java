package io.vpv.math.problemgenerateor.config;

import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityProtection securityProtection;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityProtection);
    }

}

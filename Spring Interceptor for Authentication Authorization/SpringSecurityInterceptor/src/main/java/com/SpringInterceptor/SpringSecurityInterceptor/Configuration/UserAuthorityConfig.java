package com.SpringInterceptor.SpringSecurityInterceptor.Configuration;

import com.SpringInterceptor.SpringSecurityInterceptor.Interceptor.UserAuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class UserAuthorityConfig implements WebMvcConfigurer {

    @Autowired
    UserAuthorizationInterceptor userAuthorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthorizationInterceptor);
    }
}

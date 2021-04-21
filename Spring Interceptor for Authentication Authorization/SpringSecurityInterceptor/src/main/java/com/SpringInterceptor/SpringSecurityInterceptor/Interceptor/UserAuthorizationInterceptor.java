package com.SpringInterceptor.SpringSecurityInterceptor.Interceptor;

import com.SpringInterceptor.SpringSecurityInterceptor.Entity.AclEntity;
import com.SpringInterceptor.SpringSecurityInterceptor.Repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserAuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    AclRepository aclRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        String requestedUrl = request.getRequestURI();
        Collection<GrantedAuthority> authorities =  user.getAuthorities();

        List<String> roles = new ArrayList<>();
        authorities.forEach(authority ->{
            roles.add(authority.getAuthority());
        });

        List<AclEntity> aclEntities = aclRepository.getByUrlAndRoles(requestedUrl, roles);

        if(requestedUrl.equals("/error"))
            return true;

        if(aclEntities.size()>0)
            return true;

        return false;

//        return true;//super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}

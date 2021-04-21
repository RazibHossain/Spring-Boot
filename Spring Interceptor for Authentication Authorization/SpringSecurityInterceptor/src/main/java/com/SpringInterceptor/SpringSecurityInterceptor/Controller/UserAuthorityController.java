package com.SpringInterceptor.SpringSecurityInterceptor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserAuthorityController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Object ShowDetails(HttpServletRequest request){
        return "index";
    }


}

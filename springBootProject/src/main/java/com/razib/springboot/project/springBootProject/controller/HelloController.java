package com.razib.springboot.project.springBootProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object hellohome(HttpServletRequest request){
        return "Home";
    }
    @RequestMapping(value = "/Home", method = RequestMethod.GET)
    public Object hellohome2(HttpServletRequest request){
        return "Home";
    }
    @RequestMapping(value = "/Failure", method = RequestMethod.GET)
    public Object failerror(HttpServletRequest request){
        return "Failure";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public Object login(HttpServletRequest request){
        return "/Login_Logout/Login";
    }


}

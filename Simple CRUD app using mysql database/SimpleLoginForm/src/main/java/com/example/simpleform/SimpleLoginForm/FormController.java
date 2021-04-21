package com.example.simpleform.SimpleLoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {
    @Autowired
    LogRepository repo;

    @RequestMapping(value = "/home", method=RequestMethod.GET)
    public Object login(HttpServletRequest request){
        System.out.println("Working");
       // System.out.println(request.get);
        return "index";
    }
    @RequestMapping("/addEntry")
    public Object UserDetails(Login log){
        repo.save(log);
        return "index";
    }
    @RequestMapping("/getEntry")
    public ModelAndView getEntry(@RequestParam int ID){
        ModelAndView mv=new ModelAndView("userdetails");
        Login log=repo.findById(ID).orElse(null);
        mv.addObject("log", log);
        return mv;
    }

}

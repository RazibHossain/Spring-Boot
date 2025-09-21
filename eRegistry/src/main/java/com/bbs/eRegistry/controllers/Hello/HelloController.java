package com.bbs.eRegistry.controllers.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/Hello/", method = RequestMethod.GET)
    @ResponseBody
    public Object Hello()  {
        return "hello";
    }
}

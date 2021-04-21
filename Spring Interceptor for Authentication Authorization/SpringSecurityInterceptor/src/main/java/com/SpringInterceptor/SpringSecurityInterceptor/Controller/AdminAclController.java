package com.SpringInterceptor.SpringSecurityInterceptor.Controller;

import com.SpringInterceptor.SpringSecurityInterceptor.Entity.AclEntity;
import com.SpringInterceptor.SpringSecurityInterceptor.Repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminAclController {
    @Autowired
    AclRepository aclRepository;

    @RequestMapping("/admin")
    public Object showTable( ){

        ModelAndView mv=new ModelAndView("userDetails");
        Iterable<AclEntity> acl=  aclRepository.findAll();
        mv.addObject("acl", acl);
        return mv;





    }
}

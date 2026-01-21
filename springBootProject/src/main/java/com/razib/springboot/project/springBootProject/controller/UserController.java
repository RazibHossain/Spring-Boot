package com.razib.springboot.project.springBootProject.controller;

import com.razib.springboot.project.springBootProject.Dao.UserDao;
import com.razib.springboot.project.springBootProject.ReportFormDto;
import com.razib.springboot.project.springBootProject.Service.JasperReports.UserListReports;
import com.razib.springboot.project.springBootProject.Service.UserService;
import com.razib.springboot.project.springBootProject.model.Batch;
import com.razib.springboot.project.springBootProject.model.Users;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserListReports userListReports;
    @Autowired
    private UserDao userDao;

//    Users user = new Users();
    @RequestMapping(value = "/Add/",method = RequestMethod.GET)
    public Object userAddView(Model model){
        model.addAttribute("batchform", new Batch());
        return "/User/Add";
    }

    @RequestMapping(value = "/Add/",method = RequestMethod.POST)
    public Object userAdd(@ModelAttribute("userform") Users user){
        userService.saveUser(user);
        return  "redirect:/User/List/";
//        return"/User/List";
    }

    @RequestMapping(value = "/List/",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userlistView(){
        ModelAndView mv = new ModelAndView("/User/List");
        mv.addObject("user_list",userService.findUsers());
        return mv;
    }

    @RequestMapping(value = "/UserList/",method = RequestMethod.GET)
    @ResponseBody
    public Object userlistforJasper(){
        return userService.findUsers();
    }


    @RequestMapping(value = "/List/",method = RequestMethod.POST)
    public Object userlistShow(@ModelAttribute("userform") Users user){
        return "/User/List";
    }

    @RequestMapping(value = "/Edit/{id}/",method = RequestMethod.GET)
    public Object userEditView(@PathVariable Integer id, Model model){
        model.addAttribute("userform", userService.findUser(id));
        return "/User/Edit";
    }
    @RequestMapping(value = "/Edit/",method = RequestMethod.POST)
    public Object userEditPost(@ModelAttribute("userform") Users user){
        userService.updateUser(user);
        return  "redirect:/User/List/";
    }
    @GetMapping("/Report/")
    public String generateReport(Model model) throws FileNotFoundException, JRException {
        model.addAttribute("reportForm", new ReportFormDto());
        return "User/Report";

    }

    @PostMapping("/Report/")
        public Object reportGen(@ModelAttribute("reportForm") ReportFormDto reportFormDto) {
//        System.out.println(userDao.getUserReport(reportFormDto.getUserName(),reportFormDto.getUserId()));
        List<Users> usersList = userDao.getUserReport(reportFormDto.getUserName(),reportFormDto.getUserId());
        String format = reportFormDto.getReportFormat();
        try {
            userListReports.exportReport(format,usersList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
        System.out.println(reportFormDto);
        return "User/ReportSuccessPage";
    }

    @RequestMapping(value = "/Delete/{id}/",method = RequestMethod.GET)
    public Object userDeleteView(@PathVariable Integer id){
    userService.deleteById(id);
        return  "redirect:/User/List/";
    }
}

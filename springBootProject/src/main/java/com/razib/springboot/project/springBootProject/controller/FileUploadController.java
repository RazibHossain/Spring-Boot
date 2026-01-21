package com.razib.springboot.project.springBootProject.controller;

import com.razib.springboot.project.springBootProject.Interface.IExeltoDataService;
import com.razib.springboot.project.springBootProject.Interface.IFileService;
import com.razib.springboot.project.springBootProject.model.BulkStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Upload")
public class FileUploadController {
    @Autowired
    IFileService IFileService;

    @Autowired
    IExeltoDataService iExeltoDataService;

    @RequestMapping(value = "/file",method = RequestMethod.GET)
    public Object uploadView(){
        return "/Uploader/Upload";
    }
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public Object uploadSave(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){

        if (file.getOriginalFilename().equals("")){
            redirectAttributes.addFlashAttribute("error_message",
                    "File name can not be empty");
            return "redirect:/Upload/file/";
        }
        IFileService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //upload file
        return "/Uploader/Upload";
    }

    @RequestMapping(value = "/fileSave",method = RequestMethod.GET)
    public Object saveFileView(Model model){

        List<BulkStudent> excelDataAsList = iExeltoDataService.getExcelDataAsList();

        //save upload file to db
        return "/Uploader/Upload";
    }





}

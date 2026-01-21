package com.razib.springboot.project.springBootProject.Service.JasperReports;

import com.razib.springboot.project.springBootProject.Repository.UserRepository;
import com.razib.springboot.project.springBootProject.model.Users;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserListReports {

    @Autowired
    private UserRepository userRepository;



    public String exportReport(String reportFormat, List<Users> usersList) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Dell\\Desktop\\razib\\RemoteSystemsTempFiles";
//        List<Users> users = userRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:UserList.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usersList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "RazibHossain");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }

        return "report generated in path : " + path;
    }

}

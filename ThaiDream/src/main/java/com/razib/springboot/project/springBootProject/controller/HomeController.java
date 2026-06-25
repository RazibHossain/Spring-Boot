package com.razib.springboot.project.springBootProject.controller;


import com.razib.springboot.project.springBootProject.model.TourPackage;
import com.razib.springboot.project.springBootProject.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private TourService tourService;

    @GetMapping("/")
    public String home(Model model) {
        List<TourPackage> allPackages = tourService.getAllPackages();
        List<TourPackage> freePackages = tourService.getFreePackages();
        model.addAttribute("packages", allPackages);
        model.addAttribute("freePackages", freePackages);
        model.addAttribute("totalPackages", allPackages.size());
        return "index";
    }

    @GetMapping("/packages")
    public String packages(@RequestParam(required = false) String category, Model model) {
        List<TourPackage> packages;
        if (category != null && !category.isEmpty()) {
            packages = tourService.getPackagesByCategory(category);
        } else {
            packages = tourService.getAllPackages();
        }
        model.addAttribute("packages", packages);
        model.addAttribute("selectedCategory", category);
        return "packages";
    }

    @GetMapping("/package/{id}")
    public String packageDetail(@PathVariable String id, Model model) {
        Optional<TourPackage> pkg = tourService.getPackageById(id);
        if (!pkg.isPresent()) {
            return "redirect:/packages";
        }
        model.addAttribute("package", pkg.get());
        return "package-detail";
    }

    @GetMapping("/free-packages")
    public String freePackages(Model model) {
        model.addAttribute("freePackages", tourService.getFreePackages());
        return "free-packages";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}

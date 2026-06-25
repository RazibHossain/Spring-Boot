package com.razib.springboot.project.springBootProject.controller;


import com.razib.springboot.project.springBootProject.model.TourPackage;
import com.razib.springboot.project.springBootProject.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private TourService tourService;

    @GetMapping("/packages")
    public ResponseEntity<List<TourPackage>> getAllPackages(@RequestParam(required = false) String category) {
        List<TourPackage> packages;
        if (category != null && !category.isEmpty()) {
            packages = tourService.getPackagesByCategory(category);
        } else {
            packages = tourService.getAllPackages();
        }
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/packages/{id}")
    public ResponseEntity<TourPackage> getPackage(@PathVariable String id) {
        Optional<TourPackage> pkg = tourService.getPackageById(id);
        return pkg.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/packages/free")
    public ResponseEntity<List<TourPackage>> getFreePackages() {
        return ResponseEntity.ok(tourService.getFreePackages());
    }
}

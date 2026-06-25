package com.razib.springboot.project.springBootProject.controller;


import com.razib.springboot.project.springBootProject.model.Booking;
import com.razib.springboot.project.springBootProject.model.TourPackage;
import com.razib.springboot.project.springBootProject.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private TourService tourService;

    @GetMapping("/{packageId}")
    public String bookingForm(@PathVariable String packageId, Model model) {
        Optional<TourPackage> pkg = tourService.getPackageById(packageId);
        if (!pkg.isPresent()) {
            return "redirect:/packages";
        }
        model.addAttribute("package", pkg.get());
        model.addAttribute("booking", new Booking());
        return "booking";
    }

    @PostMapping("/confirm")
    public String confirmBooking(@ModelAttribute Booking booking, Model model) {
        Booking saved = tourService.createBooking(booking);
        model.addAttribute("booking", saved);

        Optional<TourPackage> pkg = tourService.getPackageById(saved.getPackageId());
        pkg.ifPresent(p -> model.addAttribute("package", p));

        return "booking-confirm";
    }
}

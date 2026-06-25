package com.razib.springboot.project.springBootProject.service;


import com.razib.springboot.project.springBootProject.data.TourDataStore;
import com.razib.springboot.project.springBootProject.model.Booking;
import com.razib.springboot.project.springBootProject.model.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TourService {

    @Autowired
    private TourDataStore dataStore;

    public List<TourPackage> getAllPackages() {
        return dataStore.getAllPackages();
    }

    public Optional<TourPackage> getPackageById(String id) {
        return dataStore.getPackageById(id);
    }

    public List<TourPackage> getFreePackages() {
        return dataStore.getFreePackages();
    }

    public List<TourPackage> getPackagesByCategory(String category) {
        return dataStore.getPackagesByCategory(category);
    }

    public Booking createBooking(Booking booking) {
        String bookingId = "TH-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        booking.setBookingId(bookingId);
        booking.setStatus("Confirmed");
        booking.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")));

        Optional<TourPackage> pkg = dataStore.getPackageById(booking.getPackageId());
        pkg.ifPresent(p -> {
            booking.setPackageName(p.getName());
            booking.setFreePackage(p.isFreePackage());
        });

        return dataStore.saveBooking(booking);
    }

    public Optional<Booking> getBookingById(String id) {
        return dataStore.getBookingById(id);
    }

    public List<Booking> getAllBookings() {
        return dataStore.getAllBookings();
    }
}

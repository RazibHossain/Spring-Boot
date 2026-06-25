package com.razib.springboot.project.springBootProject.data;

import com.razib.springboot.project.springBootProject.model.Booking;
import com.razib.springboot.project.springBootProject.model.TourPackage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class TourDataStore {

    private final List<TourPackage> packages = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Package 1 - Bangkok City
        packages.add(new TourPackage(
            "PKG001", "Bangkok City Explorer", "Bangkok", "5 Days / 4 Nights",
            1299.00, false,
            "https://images.unsplash.com/photo-1563492065599-3520f775eeed?w=800",
            "Discover the magic of Bangkok – the City of Angels. Explore magnificent temples, vibrant street markets, and iconic landmarks on this fully-guided city adventure.",
            "City", 20, 4.8,
            Arrays.asList("4-Star Hotel Accommodation", "Daily Breakfast", "Airport Transfers", "English Speaking Guide", "Entrance Fees"),
            Arrays.asList("Grand Palace & Wat Phra Kaew", "Wat Arun Temple", "Chatuchak Weekend Market", "Chao Phraya River Cruise", "Street Food Night Tour"),
            "Easy"
        ));

        // Package 2 - Phuket Beach
        packages.add(new TourPackage(
            "PKG002", "Phuket Paradise Retreat", "Phuket", "7 Days / 6 Nights",
            1899.00, false,
            "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800",
            "Bask in the crystal-clear waters and pristine beaches of Phuket. Experience island hopping, snorkeling, and vibrant nightlife in Thailand's most beloved beach destination.",
            "Beach", 16, 4.9,
            Arrays.asList("Beachfront Resort", "All Meals Included", "Island Hopping Boat Trip", "Snorkeling Equipment", "Airport Transfers"),
            Arrays.asList("Phi Phi Islands Day Trip", "James Bond Island", "Big Buddha Visit", "Patong Beach", "Old Phuket Town Walking Tour"),
            "Easy"
        ));

        // Package 3 - Chiang Mai Culture
        packages.add(new TourPackage(
            "PKG003", "Chiang Mai Cultural Journey", "Chiang Mai", "6 Days / 5 Nights",
            1599.00, false,
            "https://images.unsplash.com/photo-1528181304800-259b08848526?w=800",
            "Immerse yourself in the rich cultural heritage of Northern Thailand. Visit ancient temples, meet hill tribes, and experience a Thai cooking class in this charming mountain city.",
            "Cultural", 12, 4.7,
            Arrays.asList("Boutique Hotel Stay", "Daily Breakfast", "Elephant Sanctuary Visit", "Thai Cooking Class", "Tuk-Tuk Tours"),
            Arrays.asList("Doi Suthep Temple", "Elephant Nature Park", "Night Bazaar Shopping", "Hill Tribe Village Visit", "Thai Massage Experience"),
            "Easy"
        ));

        // Package 4 - Krabi Adventure
        packages.add(new TourPackage(
            "PKG004", "Krabi Adventure & Nature", "Krabi", "8 Days / 7 Nights",
            2199.00, false,
            "https://images.unsplash.com/photo-1559628233-100c798642d7?w=800",
            "Explore the dramatic limestone cliffs and hidden lagoons of Krabi. Perfect for adventure lovers seeking rock climbing, kayaking, and secret beach discoveries.",
            "Adventure", 10, 4.6,
            Arrays.asList("Eco-Resort Accommodation", "Breakfast & Dinner", "Rock Climbing Lessons", "Sea Kayaking", "National Park Fees"),
            Arrays.asList("Railay Beach Access", "Four Islands Tour", "Tiger Cave Temple Climb", "Kayaking in Mangroves", "Sunset Longtail Boat"),
            "Moderate"
        ));

        // Package 5 - Thailand Grand Tour (FREE)
        packages.add(new TourPackage(
            "PKG005", "Thailand Grand Tour – FREE Package", "Bangkok, Chiang Mai & Phuket", "14 Days / 13 Nights",
            0.00, true,
            "https://images.unsplash.com/photo-1552465011-b4e21bf6e79a?w=800",
            "Experience the BEST of Thailand absolutely FREE! Our flagship package covers Bangkok, Chiang Mai, and Phuket with luxury accommodation, all meals, and exclusive experiences. Travel Thailand without spending a single dollar – just accept our one special condition revealed upon arrival.",
            "Signature Free", 8, 5.0,
            Arrays.asList("Luxury Hotel Accommodation", "All Meals (Breakfast, Lunch & Dinner)", "All Internal Flights", "Private Airport Transfers", "Expert Local Guides", "All Entrance Fees", "SIM Card & Travel Insurance", "Surprise Welcome Gift"),
            Arrays.asList("Grand Palace Bangkok", "Elephant Sanctuary Chiang Mai", "Phi Phi Islands Phuket", "Authentic Thai Cooking Class", "Floating Market Experience", "Night Safari", "Cultural Performance Show", "Exclusive Beach Dinner"),
            "Easy"
        ));

        // Package 6 - Koh Samui Luxury
        packages.add(new TourPackage(
            "PKG006", "Koh Samui Luxury Escape", "Koh Samui", "5 Days / 4 Nights",
            2499.00, false,
            "https://images.unsplash.com/photo-1540202404-d0c7fe46a1b8?w=800",
            "Indulge in the ultimate luxury escape on the stunning island of Koh Samui. Private villas, world-class spas, and exclusive beach clubs await.",
            "Luxury", 6, 4.9,
            Arrays.asList("Private Pool Villa", "All Meals & Drinks", "Spa Treatment Daily", "Private Beach Access", "Yacht Charter Half-Day"),
            Arrays.asList("Angthong Marine Park", "Big Buddha Temple", "Fisherman's Village", "Spa at Luxury Resort", "Private Beach Dinner"),
            "Easy"
        ));

        // Package 7 - Northern Trek
        packages.add(new TourPackage(
            "PKG007", "Golden Triangle Expedition", "Chiang Rai & Golden Triangle", "4 Days / 3 Nights",
            899.00, false,
            "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800",
            "Journey to the famous Golden Triangle where Thailand, Laos, and Myanmar meet. Discover ancient history, opium museum, and breathtaking mountain scenery.",
            "Adventure", 15, 4.5,
            Arrays.asList("Guesthouse Accommodation", "Daily Breakfast", "Border Crossing Experience", "Boat Ride on Mekong River", "Guide Fees"),
            Arrays.asList("White Temple (Wat Rong Khun)", "Golden Triangle Point", "Mekong River Cruise", "Opium Museum Tour", "Long-neck Village Visit"),
            "Moderate"
        ));

        // Package 8 - Samui + Free Combo
        packages.add(new TourPackage(
            "PKG008", "Samui Wellness FREE Package", "Koh Samui", "10 Days / 9 Nights",
            0.00, true,
            "https://images.unsplash.com/photo-1571896349842-33c89424de2d?w=800",
            "A full 10-day wellness and detox retreat on Koh Samui – completely FREE. Yoga, meditation, healthy cuisine, and spa treatments are all included. Just fulfill our unique arrival condition and enjoy paradise for free.",
            "Wellness Free", 6, 4.8,
            Arrays.asList("Wellness Resort Stay", "Healthy Meals 3x Daily", "Daily Yoga & Meditation", "2 Spa Treatments Per Day", "Detox Program", "Airport Transfers", "Wellness Consultation"),
            Arrays.asList("Morning Beach Yoga", "Thai Herbal Steam Bath", "Island Wellness Walk", "Sound Healing Sessions", "Organic Farm Visit", "Sunset Meditation", "Traditional Thai Massage"),
            "Easy"
        ));
    }

    public List<TourPackage> getAllPackages() {
        return Collections.unmodifiableList(packages);
    }

    public Optional<TourPackage> getPackageById(String id) {
        return packages.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<TourPackage> getFreePackages() {
        List<TourPackage> free = new ArrayList<>();
        for (TourPackage p : packages) {
            if (p.isFreePackage()) free.add(p);
        }
        return free;
    }

    public List<TourPackage> getPackagesByCategory(String category) {
        List<TourPackage> result = new ArrayList<>();
        for (TourPackage p : packages) {
            if (p.getCategory().equalsIgnoreCase(category)) result.add(p);
        }
        return result;
    }

    public Booking saveBooking(Booking booking) {
        bookings.add(booking);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public Optional<Booking> getBookingById(String id) {
        return bookings.stream().filter(b -> b.getBookingId().equals(id)).findFirst();
    }
}

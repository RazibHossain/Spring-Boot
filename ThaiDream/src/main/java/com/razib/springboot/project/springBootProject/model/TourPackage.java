package com.razib.springboot.project.springBootProject.model;

import java.util.List;

public class TourPackage {
    private String id;
    private String name;
    private String destination;
    private String duration;
    private double price;
    private boolean freePackage;
    private String imageUrl;
    private String description;
    private String category;
    private int maxGuests;
    private double rating;
    private List<String> includes;
    private List<String> highlights;
    private String difficulty;

    public TourPackage() {}

    public TourPackage(String id, String name, String destination, String duration,
                       double price, boolean freePackage, String imageUrl,
                       String description, String category, int maxGuests,
                       double rating, List<String> includes, List<String> highlights, String difficulty) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.duration = duration;
        this.price = price;
        this.freePackage = freePackage;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
        this.maxGuests = maxGuests;
        this.rating = rating;
        this.includes = includes;
        this.highlights = highlights;
        this.difficulty = difficulty;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isFreePackage() { return freePackage; }
    public void setFreePackage(boolean freePackage) { this.freePackage = freePackage; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getMaxGuests() { return maxGuests; }
    public void setMaxGuests(int maxGuests) { this.maxGuests = maxGuests; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public List<String> getIncludes() { return includes; }
    public void setIncludes(List<String> includes) { this.includes = includes; }
    public List<String> getHighlights() { return highlights; }
    public void setHighlights(List<String> highlights) { this.highlights = highlights; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
}

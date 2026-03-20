package model;

import exception.InvalidResourceException;

public class Resource {
    private String id;
    private String title;
    private String location;
    private String author;
    private int year;

    public Resource(String id, String title, String location, int year, String author)
            throws InvalidResourceException {

        if (id == null || id.isEmpty()) {
            throw new InvalidResourceException("ID cannot be empty");
        }

        if (title == null || title.isEmpty()) {
            throw new InvalidResourceException("Title cannot be empty");
        }

        if (location == null || location.isEmpty()){
            throw new InvalidResourceException("Location cannot be empty");
        }
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + year + " | " + author;
    }
} 

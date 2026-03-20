package org.example;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Intersection> intersections;
    private List<Street> streets;

    public City(String name) {
        this.name = name;
        this.intersections = new ArrayList<>();
        this.streets = new ArrayList<>();
    }

    public void addIntersection(Intersection intersection) {
        intersections.add(intersection);
    }

    public void addStreet(Street street) {
        streets.add(street);
    }

    public String getName() { return name; }
    public List<Intersection> getIntersections() { return intersections; }
    public List<Street> getStreets() { return streets; }
} 

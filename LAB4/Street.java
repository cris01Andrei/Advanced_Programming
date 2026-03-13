package org.example;

public class Street implements Comparable<Street> {
    private String name;
    private double length;
    private Intersection u;
    private Intersection v;

    public Street(String name, double length, Intersection u, Intersection v) {
        this.name = name;
        this.length = length;
        this.u = u;
        this.v = v;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public Intersection getU() {
        return u;
    }

    public Intersection getV() {
        return v;
    }

    @Override
    public int compareTo(Street other) {
        int lengthComparison = Double.compare(this.length, other.length);
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + length + "m) leagă " + u + " de " + v;
    }
}
package org.example;

public class Street {
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

    public String getName() { return name; }
    public double getLength() { return length; }
    public Intersection getU() { return u; }
    public Intersection getV() { return v; }

    @Override
    public String toString() {
        return name + " (" + length + "m) leagă " + u.getName() + " de " + v.getName();
    }
}
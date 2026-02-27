import java.util.*;
import java.lang.*;

enum Location_Type {
    CITY, AIRPORT, GAS_STATION, COUNTRY, COUNTY;
}

enum Road_Type {
    EXPRESS, HIGHWAY, NATIONAL, INTERNATIONAL;
}

class Location {
    private String name;
    private Location_Type type;
    private double x, y;

    public Location(String name, Location_Type type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getName() { return this.name; }
    public Location_Type getType() { return this.type; }
    public double getX() { return this.x; }
    public double getY() { return this.y; }


    public void setType(Location_Type type) { this.type = type; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

class Road {
    private Road_Type type;
    private int speed_limit;
    private double length;
    private Location nodeA, nodeB;

    public Road(Road_Type type, int speed_limit, double length, Location a, Location b) {
        this.type = type;
        this.speed_limit = speed_limit;
        this.nodeA = a;
        this.nodeB = b;

        double minDistance = calculateEuclidian(a, b);
        if (length < minDistance) {
            System.out.println("Avertisment: Lungimea " + length + " este mai mică decât distanța directă");
            this.length = minDistance;
        } else {
            this.length = length;
        }
    }


    public Road_Type getType() { return this.type; }
    public int getSpeed_limit() { return this.speed_limit; }
    public double getLength() { return this.length; }
    public Location getFirstLocation() { return this.nodeA; }
    public Location getSecondLocation() { return this.nodeB; }

    public void setType(Road_Type type) { this.type = type; }
    public void setSpeed_limit(int speed_limit) { this.speed_limit = speed_limit; }
    public void setFirstLocation(Location a) { this.nodeA = a; }
    public void setSecondLocation(Location b) { this.nodeB = b; }

    public void setLength(double length) {
        if (length >= calculateEuclidian(this.nodeA, this.nodeB)) {
            this.length = length;
        } else {
            System.out.println("Eroare: Lungime prea mică în raport cu distanța euclidiană.");
        }
    }

    private double calculateEuclidian(Location a, Location b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", limit=" + speed_limit + "km/h" +
                ", length=" + String.format("%.2f", length) +
                ", A=" + nodeA.getName() +
                ", B=" + nodeB.getName() +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Location iasi = new Location("Iasi", Location_Type.CITY, 47.1585, 27.5681);
        Location bucuresti = new Location("Bucuresti", Location_Type.CITY, 44.4268, 26.1025);
        Location gasStation = new Location("OMV", Location_Type.GAS_STATION, 46.0000, 26.8000);

        Road e85 = new Road(Road_Type.EXPRESS, 100, 389.0, iasi, bucuresti);
        Road drumScurt = new Road(Road_Type.NATIONAL, 90, 0.5, iasi, gasStation);

        System.out.println("\n--- Locații ---");
        System.out.println(iasi);
        System.out.println(bucuresti);
        System.out.println(gasStation);

        System.out.println("\n--- Drumuri ---");
        System.out.println(e85);
        System.out.println(drumScurt);
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Intersection> pct_int = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            pct_int.add(new Intersection("I" + i));
        }

        List<Street> streets = new LinkedList<>();
        streets.add(new Street("Magheru", 2.5, pct_int.get(0), pct_int.get(1)));
        streets.add(new Street("Victoriei", 1.2, pct_int.get(1), pct_int.get(2)));
        streets.add(new Street("Unirii", 3.0, pct_int.get(2), pct_int.get(3)));
        streets.add(new Street("Aviatorilor", 1.8, pct_int.get(3), pct_int.get(4)));
        streets.add(new Street("Dorobanti", 0.9, pct_int.get(4), pct_int.get(5)));
        streets.add(new Street("Kiseleff", 2.1, pct_int.get(5), pct_int.get(6)));
        streets.add(new Street("Lipscani", 0.5, pct_int.get(6), pct_int.get(7)));
        streets.add(new Street("Carol I", 1.5, pct_int.get(7), pct_int.get(8)));
        streets.add(new Street("Splai", 4.2, pct_int.get(8), pct_int.get(9)));
        streets.add(new Street("Eroilor", 1.1, pct_int.get(9), pct_int.get(0)));

        streets.sort(Comparator.comparingDouble(Street::getLength));

        System.out.println("--- Străzi sortate crescător după lungime ---");
        for (Street s : streets) {
            System.out.println(s);
        }

        Set<Intersection> intersectionSet = new HashSet<>(pct_int);

        System.out.println("\n--- Verificare Proprietate HashSet (Fără Duplicate) ---");
        System.out.println("Dimensiunea inițială a setului: " + intersectionSet.size());

        Intersection duplicateIntersection = new Intersection("I0");
        boolean isAdded = intersectionSet.add(duplicateIntersection);

        System.out.println("S-a reușit adăugarea duplicatului 'I0'? : " + isAdded);
        System.out.println("Dimensiunea setului după încercare: " + intersectionSet.size());
    }
}
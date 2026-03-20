package org.example;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        City myCity = new City(faker.address().city());

        // 1. Generăm 10 intersecții cu nume false
        for (int i = 0; i < 10; i++) {
            myCity.addIntersection(new Intersection(faker.address().streetName() + " Square"));
        }

        List<Intersection> nodes = myCity.getIntersections();

        // 2. Generăm străzi aleatorii care leagă aceste intersecții
        // Adăugăm destule străzi pe un singur nod pentru a testa filtrul (ex: nodes.get(1))
        myCity.addStreet(new Street(faker.address().streetName(), 3.5, nodes.get(0), nodes.get(1)));
        myCity.addStreet(new Street(faker.address().streetName(), 4.2, nodes.get(1), nodes.get(2)));
        myCity.addStreet(new Street(faker.address().streetName(), 1.5, nodes.get(1), nodes.get(3)));
        myCity.addStreet(new Street(faker.address().streetName(), 5.1, nodes.get(1), nodes.get(4)));
        myCity.addStreet(new Street(faker.address().streetName(), 2.8, nodes.get(4), nodes.get(5)));

        System.out.println("Bine ați venit în orașul: " + myCity.getName());

        // 3. CERINȚA CU STREAMS: Străzi > 3.0m care se unesc cu cel puțin alte 3 străzi
        double minLength = 3.0;

        List<Street> filteredStreets = myCity.getStreets().stream()
                .filter(s -> s.getLength() > minLength)
                .filter(s -> countAdjacent(s, myCity.getStreets()) >= 3)
                .collect(Collectors.toList());

        System.out.println("\n--- Străzi mai lungi de " + minLength + "m cu >= 3 intersecții ---");
        filteredStreets.forEach(System.out::println);

        // 4. Testarea algoritmului de grafuri
        System.out.println("\n--- Calcularea alternativelor de cablare ---");
        KSpanningTreeAlgorithm algorithm = new KSpanningTreeAlgorithm(myCity);
        algorithm.findTopSolutions(3); // Afișează top 3 soluții
    }

    // Metodă ajutătoare pentru a număra străzile adiacente
    private static int countAdjacent(Street target, List<Street> allStreets) {
        return (int) allStreets.stream()
                .filter(s -> !s.equals(target)) // Excludem strada însăși
                .filter(s -> s.getU().equals(target.getU()) || s.getV().equals(target.getU()) ||
                        s.getU().equals(target.getV()) || s.getV().equals(target.getV()))
                .count();
    }
} 

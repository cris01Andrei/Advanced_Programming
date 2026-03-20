package org.example;

import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KSpanningTreeAlgorithm {
    private Graph<Intersection, DefaultWeightedEdge> graph;

    public KSpanningTreeAlgorithm(City city) {
        // Inițializăm graful cu ponderi (costuri/lungimi)
        this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (Intersection i : city.getIntersections()) {
            graph.addVertex(i);
        }

        for (Street s : city.getStreets()) {
            DefaultWeightedEdge edge = graph.addEdge(s.getU(), s.getV());
            if (edge != null) {
                graph.setEdgeWeight(edge, s.getLength());
            }
        }
    }

    public void findTopSolutions(int k) {
        List<Double> validCosts = new ArrayList<>();

        // 1. Găsim rețeaua optimă absolută (MST)
        KruskalMinimumSpanningTree<Intersection, DefaultWeightedEdge> baseAlgorithm =
                new KruskalMinimumSpanningTree<>(graph);

        // Dacă graful nu este complet conectat, nu putem continua
        if (baseAlgorithm.getSpanningTree().getEdges().size() != graph.vertexSet().size() - 1) {
            System.out.println("Orașul nu este complet conectat!");
            return;
        }

        double absoluteMinCost = baseAlgorithm.getSpanningTree().getWeight();
        validCosts.add(absoluteMinCost);

        // 2. Căutăm alternative
        // Pentru fiecare muchie (stradă) din rețeaua optimă, o eliminăm temporar
        for (DefaultWeightedEdge edge : baseAlgorithm.getSpanningTree().getEdges()) {
            Intersection source = graph.getEdgeSource(edge);
            Intersection target = graph.getEdgeTarget(edge);
            double weight = graph.getEdgeWeight(edge);

            // Tăiem strada temporar
            graph.removeEdge(edge);

            // Recalculăm costul pentru a găsi "Planul B"
            KruskalMinimumSpanningTree<Intersection, DefaultWeightedEdge> altAlgorithm =
                    new KruskalMinimumSpanningTree<>(graph);

            // Verificăm dacă orașul a rămas conectat chiar și fără acea stradă
            if (altAlgorithm.getSpanningTree().getEdges().size() == graph.vertexSet().size() - 1) {
                validCosts.add(altAlgorithm.getSpanningTree().getWeight());
            }

            // Punem strada înapoi pentru următoarea iterație
            DefaultWeightedEdge restoredEdge = graph.addEdge(source, target);
            graph.setEdgeWeight(restoredEdge, weight);
        }

        // 3. Sortăm rezultatele crescător și eliminăm duplicatele
        List<Double> finalSolutions = validCosts.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .limit(k)
                .collect(Collectors.toList());

        // 4. Afișăm pe ecran
        for (int i = 0; i < finalSolutions.size(); i++) {
            System.out.println("Soluția " + (i + 1) + ": Cost total = " + finalSolutions.get(i));
        }
    }
} 

package org.example.spring.client;

import org.example.spring.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class MovieClient {

    private static final String BASE_URL = "http://localhost:8081/api/movies";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        try {
            System.out.println("=== Incepere Testare Client REST ===");

            Movie newMovie = new Movie();
            newMovie.setTitle("Interstellar 2 (Test)");
            newMovie.setScore(9.0);
            newMovie.setDuration(150);

            ResponseEntity<Movie> postResponse = restTemplate.postForEntity(BASE_URL, newMovie, Movie.class);
            Long newId = postResponse.getBody().getId();
            System.out.println("1. Film creat cu succes! ID: " + newId);


            String allMovies = restTemplate.getForObject(BASE_URL, String.class);
            System.out.println("2. Filmele din baza de date: " + allMovies);


            newMovie.setTitle("Interstellar 2 (Modificat)");
            restTemplate.put(BASE_URL + "/" + newId, newMovie);
            System.out.println("3. Film modificat cu succes (PUT).");

            Map<String, Double> scoreUpdate = new HashMap<>();
            scoreUpdate.put("score", 9.9);
            restTemplate.patchForObject(BASE_URL + "/" + newId + "/score", scoreUpdate, Movie.class);
            System.out.println("4. Scor actualizat cu succes (PATCH).");

            restTemplate.delete(BASE_URL + "/" + newId);
            System.out.println("5. Film sters cu succes (DELETE).");

            System.out.println("=== Testare Finalizata ===");

        } catch (Exception e) {
            System.err.println("A aparut o eroare: " + e.getMessage());
        }
    }
}
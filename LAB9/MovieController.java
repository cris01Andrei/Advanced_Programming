package org.example.spring.controller;

import org.example.spring.exception.ResourceNotFoundException;
import org.example.spring.model.Movie;
import org.example.spring.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }



    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filmul cu ID-ul " + id + " nu a fost găsit."));

        movie.setTitle(movieDetails.getTitle());
        movie.setDuration(movieDetails.getDuration());
        movie.setScore(movieDetails.getScore());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setGenreId(movieDetails.getGenreId());

        return ResponseEntity.ok(movieRepository.save(movie));
    }

    @PatchMapping("/{id}/score")
    public ResponseEntity<Movie> updateMovieScore(@PathVariable Long id, @RequestBody Map<String, Double> updates) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filmul cu ID-ul " + id + " nu a fost găsit."));

        if (updates.containsKey("score")) {
            movie.setScore(updates.get("score"));
            movieRepository.save(movie);
        }
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filmul cu ID-ul " + id + " nu a fost găsit."));

        movieRepository.delete(movie);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/report")
    public ModelAndView getReport() {
        ModelAndView mav = new ModelAndView("report");
        mav.addObject("movies", movieRepository.findAll());
        return mav;
    }
}
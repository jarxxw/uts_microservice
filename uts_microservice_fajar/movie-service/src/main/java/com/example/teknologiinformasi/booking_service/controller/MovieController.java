package com.example.teknologiinformasi.booking_service.controller;

// import com.example.teknologiinformasi.model.Movie;
// import com.example.teknologiinformasi.service.MovieService;
// import com.example.teknologiinformasi.model.Movie;
// import com.example.teknologiinformasi.service.MovieService;
import com.example.teknologiinformasi.booking_service.model.Movie;
import com.example.teknologiinformasi.booking_service.repository.MovieRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies() {
        log.info("GET /movies accessed");
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        log.info("GET /movies/{} accessed", id);
        return movieRepository.findById(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        log.info("POST /movies accessed with body: {}", movie);
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        log.info("PUT /movies/{} accessed with body: {}", id, movie);
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        log.info("DELETE /movies/{} accessed", id);
        movieRepository.deleteById(id);
    }
}

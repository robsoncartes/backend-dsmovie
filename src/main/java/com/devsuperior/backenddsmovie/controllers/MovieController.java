package com.devsuperior.backenddsmovie.controllers;

import com.devsuperior.backenddsmovie.dtos.MovieDTO;
import com.devsuperior.backenddsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Page<MovieDTO> getMovies(Pageable pageable) {

        return movieService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {

        return movieService.findById(id);
    }
}

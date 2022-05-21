package com.devsuperior.backenddsmovie.services;

import com.devsuperior.backenddsmovie.dtos.MovieDTO;
import com.devsuperior.backenddsmovie.entities.Movie;
import com.devsuperior.backenddsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {

        Page<Movie> movies = movieRepository.findAll(pageable);

        return movies.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {

        Movie movie = movieRepository.findById(id).get();

        return new MovieDTO(movie);
    }
}

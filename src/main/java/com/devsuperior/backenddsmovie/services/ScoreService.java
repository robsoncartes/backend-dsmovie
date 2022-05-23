package com.devsuperior.backenddsmovie.services;

import com.devsuperior.backenddsmovie.dtos.MovieDTO;
import com.devsuperior.backenddsmovie.dtos.ScoreDTO;
import com.devsuperior.backenddsmovie.entities.Movie;
import com.devsuperior.backenddsmovie.entities.Score;
import com.devsuperior.backenddsmovie.entities.User;
import com.devsuperior.backenddsmovie.repositories.MovieRepository;
import com.devsuperior.backenddsmovie.repositories.ScoreRepository;
import com.devsuperior.backenddsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        scoreRepository.saveAndFlush(score);

        double sum = 0.0;

        for (Score s : movie.getScores())
            sum += s.getValue();

        int size = movie.getScores().size();
        double average = (sum / size);
        movie.setScore(average);
        movie.setCount(size);
        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}

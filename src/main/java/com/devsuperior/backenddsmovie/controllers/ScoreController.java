package com.devsuperior.backenddsmovie.controllers;

import com.devsuperior.backenddsmovie.dtos.MovieDTO;
import com.devsuperior.backenddsmovie.dtos.ScoreDTO;
import com.devsuperior.backenddsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {

        return scoreService.saveScore(dto);
    }
}

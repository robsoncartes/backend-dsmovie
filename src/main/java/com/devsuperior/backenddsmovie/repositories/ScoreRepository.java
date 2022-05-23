package com.devsuperior.backenddsmovie.repositories;


import com.devsuperior.backenddsmovie.entities.Score;
import com.devsuperior.backenddsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {


}

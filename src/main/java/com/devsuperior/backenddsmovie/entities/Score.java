package com.devsuperior.backenddsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Score {

    @EmbeddedId
    private ScorePK id = new ScorePK();
    private Double value;

    public Score() {

    }

    public ScorePK getId() {
        return id;
    }

    public void setId(ScorePK id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }
}

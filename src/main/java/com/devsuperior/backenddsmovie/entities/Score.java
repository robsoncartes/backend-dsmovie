package com.devsuperior.backenddsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_score")
public class Score implements Serializable {

    private static final long serialVersionUid = 1L;

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
        this.id.setMovie(movie);
    }

    public void setUser(User user) {
        this.id.setUser(user);
    }
}

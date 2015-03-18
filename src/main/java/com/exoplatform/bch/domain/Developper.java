package com.exoplatform.bch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by bdechateauvieux on 3/18/15.
 */
@Entity
public class Developper {
    @Id
    private Long id;
    @ManyToOne
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }
}

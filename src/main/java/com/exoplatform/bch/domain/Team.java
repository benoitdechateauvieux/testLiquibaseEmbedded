package com.exoplatform.bch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

/**
 * Created by bdechateauvieux on 3/18/15.
 */
@Entity
public class Team {
    @Id
    private Long id;

    @OneToMany(mappedBy = "team")
    private List<Developper> devs;

    public void setDevs(Collection<Developper> devs) {
        this.devs = devs;
    }

    public List<Developper> getDevs() {
        return devs;
    }

    public void setDevs(List<Developper> devs) {
        this.devs = devs;
    }

    public Long getId() {
        return id;
    }
}

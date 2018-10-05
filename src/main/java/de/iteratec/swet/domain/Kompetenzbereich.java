package de.iteratec.swet.domain;

import javax.persistence.*;

@Entity
public class Kompetenzbereich {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String kompetenzbereich;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKompetenzbereich() {
        return kompetenzbereich;
    }

    public void setKompetenzbereich(String kompetenzbereich) {
        this.kompetenzbereich = kompetenzbereich;
    }
}

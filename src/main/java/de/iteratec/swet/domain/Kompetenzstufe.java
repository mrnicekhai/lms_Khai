package de.iteratec.swet.domain;

import javax.persistence.*;

@Entity
public class Kompetenzstufe {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int kompetenzstufe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKompetenzstufe() {
        return kompetenzstufe;
    }

    public void setKompetenzstufe(int kompetenzstufe) {
        this.kompetenzstufe = kompetenzstufe;
    }
}

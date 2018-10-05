
package de.iteratec.swet.domain;

import javax.persistence.*;

/**
 * Each employee's individual skillset
 */

@Entity
public class Kompetenzeinstufung {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Kompetenzbereich kompetenzbereich;

    @OneToOne
    private Kompetenzstufe kompetenzstufe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MITARBEITER_ID")//, referencedColumnName = "MITARBEITER_ID")
    private Mitarbeiter mitarbeiter;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Kompetenzbereich getKompetenzbereich() {
        return kompetenzbereich;
    }

    public void setKompetenzbereich(final Kompetenzbereich kompetenzbereich) {
        this.kompetenzbereich = kompetenzbereich;
    }

    public Kompetenzstufe getKompetenzstufe() {
        return kompetenzstufe;
    }

    public void setKompetenzstufe(final Kompetenzstufe kompetenzstufe) {
        this.kompetenzstufe = kompetenzstufe;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(final Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
}


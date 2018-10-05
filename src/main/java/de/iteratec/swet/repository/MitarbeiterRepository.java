package de.iteratec.swet.repository;

import de.iteratec.swet.domain.Mitarbeiter;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Mitarbeiter Repository.
 *
 */
public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Long> {

    /**
     * Get an employee by first name
     *
     * @param vorName the name of the task
     * @return the Task with provided name
     */
    public Mitarbeiter findByVorName(final String vorName);

    /**
     * Get an employee by last name
     *
     * @param nachName
     * @return
     */
    public Mitarbeiter findByNachName(final String nachName);

    /**
     * Get an employee by short name
     *
     * @param kuerzel
     * @return
     */
    public Mitarbeiter findByKuerzel(final String kuerzel);
}

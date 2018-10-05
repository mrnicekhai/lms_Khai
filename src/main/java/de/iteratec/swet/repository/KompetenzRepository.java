package de.iteratec.swet.repository;

import de.iteratec.swet.domain.Kompetenzeinstufung;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Kompetenz Repository.
 *
 */
public interface KompetenzRepository extends JpaRepository<Kompetenzeinstufung, Long> {
}

package de.iteratec.swet.repository;

import de.iteratec.swet.domain.Laufbahnstufe;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Laufbahnstufe Repository.
 *
 */
public interface LaufbahnstufenRepository extends JpaRepository<Laufbahnstufe, Long> {
}

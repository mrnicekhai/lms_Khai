package de.iteratec.swet;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA Repository for demo purpose.
 *
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}

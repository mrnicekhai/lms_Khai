package de.iteratec.swet;

import org.springframework.data.repository.CrudRepository;


/**
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

}

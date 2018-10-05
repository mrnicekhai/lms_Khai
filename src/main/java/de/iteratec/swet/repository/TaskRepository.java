package de.iteratec.swet.repository;

import de.iteratec.swet.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA Repository for demo purpose.
 *
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Get a task by Name
     *
     * @param name the name of the task
     * @return the Task with provided name
     */
    public Task findByName(final String name);
}

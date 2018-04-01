package de.iteratec.swet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Task controller for demo purpose.
 *
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
@RestController
@RequestMapping(value = "api/v1/tasks")
public class TaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public void createTask(@RequestBody Task task) {
        LOGGER.info("got task: {}", task);
        taskRepository.save(task);
    }

    @GetMapping
    public Iterable<Task> getTasks() {
        LOGGER.info("getting all tasks");
        return taskRepository.findAll();
    }
}

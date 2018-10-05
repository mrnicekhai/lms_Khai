package de.iteratec.swet.api;

import de.iteratec.swet.repository.TaskRepository;
import de.iteratec.swet.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
    @RequestMapping(value = "/all")
    public Iterable<Task> getTasks() {
        LOGGER.info("getting all tasks");
        return taskRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/byName/{name}")
    public Task getTaskByName(@PathVariable("name") String name) {
        LOGGER.info("get Task by name: {}", name);
        return taskRepository.findByName(name);
    }

    @GetMapping
    @RequestMapping(value = "/byId/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Long id) {
        LOGGER.info("get Task by id: {}", id);
        return taskRepository.findById(id);
    }
}

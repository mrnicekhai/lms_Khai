package de.iteratec.swet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
@RestController
@RequestMapping(value = "rest/tasks")
public class TaskResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskResource.class);


    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void createTask(@RequestBody Task task) {
        LOGGER.info("got task: {}", task);
        taskRepository.save(task);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }
}

package de.iteratec.swet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Task entity for demo purpose.
 *
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

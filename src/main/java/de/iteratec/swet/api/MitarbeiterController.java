package de.iteratec.swet.api;

import de.iteratec.swet.exception.ResourceNotFoundException;
import de.iteratec.swet.repository.MitarbeiterRepository;
import de.iteratec.swet.domain.Mitarbeiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Mitarbeiter controller.
 */
@RestController
@RequestMapping(value = "api/")
public class MitarbeiterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MitarbeiterController.class);

    @Autowired
    private  MitarbeiterRepository mitarbeiterRepository;

    // find all employees
    @GetMapping
    @RequestMapping(value = "/all")
    public Iterable<Mitarbeiter> getMitarbeiter() {
        LOGGER.info("getting all mitarbeiter");
        return mitarbeiterRepository.findAll();
    }

    // create new employee
    // missing:
    // - @RequestParameters,
    // - hide id at output
    @PostMapping(value = "/mitarbeiter/{kuerzel}")
    public void createMitarbeiter(@RequestBody Mitarbeiter mitarbeiter, @PathVariable String kuerzel) {
        mitarbeiter.setKuerzel(kuerzel);
        LOGGER.info("created Mitarbeiter: {}", mitarbeiter);
        mitarbeiterRepository.save(mitarbeiter);
    }

    // find employee by short name
    @GetMapping
    @RequestMapping(value = "/mitarbeiter/{kuerzel}")
    public Mitarbeiter getMitarbeiterByKuerzel(@PathVariable("kuerzel") String kuerzel) {
        LOGGER.info("get Mitarbeiter by Kuerzel: {}", kuerzel);
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByKuerzel(kuerzel);
        if (mitarbeiter == null) {
            throw new ResourceNotFoundException(kuerzel, "user not found");
        }
        return mitarbeiter;
    }

    // update existing employee
    // missing:
    // - input less than 3 parameters -> all parameters have to be provided
    @PutMapping("/mitarbeiter/{kuerzel}")
    public void updateEmployee(@RequestBody Mitarbeiter updateMitarbeiter, @PathVariable String kuerzel) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByKuerzel(kuerzel);
        if (mitarbeiter == null) {
            throw new ResourceNotFoundException(kuerzel, "user not found");
        }
        if (updateMitarbeiter.getKuerzel() != mitarbeiter.getKuerzel()) {
            mitarbeiter.setKuerzel(updateMitarbeiter.getKuerzel());
        }
        if (updateMitarbeiter.getVorName() != mitarbeiter.getVorName()) {
            mitarbeiter.setVorName(updateMitarbeiter.getVorName());
        }
        if (updateMitarbeiter.getNachName() != mitarbeiter.getNachName()) {
            mitarbeiter.setNachName(updateMitarbeiter.getNachName());
        }
        LOGGER.info("updated Mitarbeiter: {}", kuerzel);
        mitarbeiterRepository.save(mitarbeiter);
    }

    // delete existing employee
    @DeleteMapping(value = "/mitarbeiter/{kuerzel}")
    public void delete(@PathVariable String kuerzel) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByKuerzel(kuerzel);
        if (mitarbeiter == null) {
            throw new ResourceNotFoundException(kuerzel, "user not found");
        }
        LOGGER.info("removed Mitarbeiter: {}", kuerzel);
        mitarbeiterRepository.delete(mitarbeiter);
    }

    @GetMapping
    @RequestMapping(value = "/byVorName/{vorName}")
    public Mitarbeiter getMitarbeiterByVorName(@PathVariable("vorName") String vorName) {
        LOGGER.info("get Mitarbeiter by vorName: {}", vorName);
        return mitarbeiterRepository.findByVorName(vorName);
    }

    @GetMapping
    @RequestMapping(value = "/byNachName/{nachName}")
    public Mitarbeiter getMitarbeiterByNachName(@PathVariable("nachName") String nachName) {
        LOGGER.info("get Mitarbeiter by nachName: {}", nachName);
        return mitarbeiterRepository.findByNachName(nachName);
    }

    @GetMapping
    @RequestMapping(value = "/byId/{id}")
    public Optional<Mitarbeiter> getMitarbeiterById(@PathVariable("id") Long id) {
        LOGGER.info("get Mitarbeiter by id: {}", id);
        return mitarbeiterRepository.findById(id);
    }
}

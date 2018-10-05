package de.iteratec.swet.api;

import de.iteratec.swet.domain.Kompetenzeinstufung;
import de.iteratec.swet.domain.Mitarbeiter;
import de.iteratec.swet.exception.ResourceNotFoundException;
import de.iteratec.swet.repository.KompetenzRepository;
import de.iteratec.swet.repository.MitarbeiterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Mitarbeiter controller.
 */
@RestController
@RequestMapping(value = "api/mitarbeiter")
public class KompetenzController {
    private static final Logger LOGGER = LoggerFactory.getLogger(KompetenzController.class);

    @Autowired
    private  KompetenzRepository kompetenzRepository;

    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    // find all employees
    @GetMapping
    @RequestMapping(value = "/{kuerzel}/kompetenzbereiche/all")
    public Iterable<Kompetenzeinstufung> getKompetenz(@PathVariable("kuerzel") String kuerzel) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByKuerzel(kuerzel);
        if (mitarbeiter == null) {
            throw new ResourceNotFoundException(kuerzel, "user not found");
        }
        LOGGER.info("getting all kompetenzeinstufungen");
        return kompetenzRepository.findAll();
    }

    // Mitarbeiter Kompetenzbereiche
    // /api/mitarbeiter/{kuerzel}/kompetenzbereiche
    // GET: liefert die aktuellen Kompetenzbereiche des MA und die entsprechende Einstufung (404 falls MA nicht gefunden)
    // PUT: Setzen der Kompetenzbereiche und -einstufungen des MA (404 falls MA nicht gefunden)
}

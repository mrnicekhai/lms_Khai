package de.iteratec.swet.api;

import de.iteratec.swet.domain.Laufbahnstufe;
import de.iteratec.swet.domain.Mitarbeiter;
import de.iteratec.swet.exception.ResourceNotFoundException;
import de.iteratec.swet.repository.LaufbahnstufenRepository;
import de.iteratec.swet.repository.MitarbeiterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mitarbeiter controller.
 */
@RestController
@RequestMapping(value = "api/mitarbeiter")
public class LaufbahnstufenController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LaufbahnstufenController.class);

    @Autowired
    private  LaufbahnstufenRepository laufbahnstufenRepository;

    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    // find all employees
    @GetMapping
    @RequestMapping(value = "/{kuerzel}/laufbahnstufen/all")
    public Iterable<Laufbahnstufe> getLaufbahnstufe(@PathVariable("kuerzel") String kuerzel) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByKuerzel(kuerzel);
        if (mitarbeiter == null) {
            throw new ResourceNotFoundException(kuerzel, "user not found");
        }
        LOGGER.info("getting all Laufbahnstufen");
        return laufbahnstufenRepository.findAll();
    }

    // Mitarbeiter Laufbahnstufen
    // /api/mitarbeiter/{kuerzel}/laufbahnstufen
    // GET: liefert die errechneten aktuellen Laufbahnstufen eines MA
    // liegen keine Kompetenzbereiche vor, wird nichts geliefert
    // (404 falls MA nicht gefunden)
}

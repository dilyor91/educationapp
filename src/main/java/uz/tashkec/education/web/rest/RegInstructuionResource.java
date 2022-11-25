package uz.tashkec.education.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;
import uz.tashkec.education.domain.RegInstructuion;
import uz.tashkec.education.repository.RegInstructuionRepository;
import uz.tashkec.education.service.RegInstructuionService;
import uz.tashkec.education.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link uz.tashkec.education.domain.RegInstructuion}.
 */
@RestController
@RequestMapping("/api")
public class RegInstructuionResource {

    private final Logger log = LoggerFactory.getLogger(RegInstructuionResource.class);

    private static final String ENTITY_NAME = "regInstructuion";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RegInstructuionService regInstructuionService;

    private final RegInstructuionRepository regInstructuionRepository;

    public RegInstructuionResource(RegInstructuionService regInstructuionService, RegInstructuionRepository regInstructuionRepository) {
        this.regInstructuionService = regInstructuionService;
        this.regInstructuionRepository = regInstructuionRepository;
    }

    /**
     * {@code POST  /reg-instructuions} : Create a new regInstructuion.
     *
     * @param regInstructuion the regInstructuion to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new regInstructuion, or with status {@code 400 (Bad Request)} if the regInstructuion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reg-instructuions")
    public ResponseEntity<RegInstructuion> createRegInstructuion(@Valid @RequestBody RegInstructuion regInstructuion)
        throws URISyntaxException {
        log.debug("REST request to save RegInstructuion : {}", regInstructuion);
        if (regInstructuion.getId() != null) {
            throw new BadRequestAlertException("A new regInstructuion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RegInstructuion result = regInstructuionService.save(regInstructuion);
        return ResponseEntity
            .created(new URI("/api/reg-instructuions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reg-instructuions/:id} : Updates an existing regInstructuion.
     *
     * @param id the id of the regInstructuion to save.
     * @param regInstructuion the regInstructuion to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated regInstructuion,
     * or with status {@code 400 (Bad Request)} if the regInstructuion is not valid,
     * or with status {@code 500 (Internal Server Error)} if the regInstructuion couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reg-instructuions/{id}")
    public ResponseEntity<RegInstructuion> updateRegInstructuion(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody RegInstructuion regInstructuion
    ) throws URISyntaxException {
        log.debug("REST request to update RegInstructuion : {}, {}", id, regInstructuion);
        if (regInstructuion.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, regInstructuion.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!regInstructuionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        RegInstructuion result = regInstructuionService.update(regInstructuion);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, regInstructuion.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /reg-instructuions/:id} : Partial updates given fields of an existing regInstructuion, field will ignore if it is null
     *
     * @param id the id of the regInstructuion to save.
     * @param regInstructuion the regInstructuion to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated regInstructuion,
     * or with status {@code 400 (Bad Request)} if the regInstructuion is not valid,
     * or with status {@code 404 (Not Found)} if the regInstructuion is not found,
     * or with status {@code 500 (Internal Server Error)} if the regInstructuion couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/reg-instructuions/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<RegInstructuion> partialUpdateRegInstructuion(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody RegInstructuion regInstructuion
    ) throws URISyntaxException {
        log.debug("REST request to partial update RegInstructuion partially : {}, {}", id, regInstructuion);
        if (regInstructuion.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, regInstructuion.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!regInstructuionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<RegInstructuion> result = regInstructuionService.partialUpdate(regInstructuion);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, regInstructuion.getId().toString())
        );
    }

    /**
     * {@code GET  /reg-instructuions} : get all the regInstructuions.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of regInstructuions in body.
     */
    @GetMapping("/reg-instructuions")
    public List<RegInstructuion> getAllRegInstructuions() {
        log.debug("REST request to get all RegInstructuions");
        return regInstructuionService.findAll();
    }

    /**
     * {@code GET  /reg-instructuions/:id} : get the "id" regInstructuion.
     *
     * @param id the id of the regInstructuion to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the regInstructuion, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reg-instructuions/{id}")
    public ResponseEntity<RegInstructuion> getRegInstructuion(@PathVariable Long id) {
        log.debug("REST request to get RegInstructuion : {}", id);
        Optional<RegInstructuion> regInstructuion = regInstructuionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(regInstructuion);
    }

    /**
     * {@code DELETE  /reg-instructuions/:id} : delete the "id" regInstructuion.
     *
     * @param id the id of the regInstructuion to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reg-instructuions/{id}")
    public ResponseEntity<Void> deleteRegInstructuion(@PathVariable Long id) {
        log.debug("REST request to delete RegInstructuion : {}", id);
        regInstructuionService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}

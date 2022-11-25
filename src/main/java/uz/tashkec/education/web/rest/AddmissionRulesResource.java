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
import uz.tashkec.education.domain.AddmissionRules;
import uz.tashkec.education.repository.AddmissionRulesRepository;
import uz.tashkec.education.service.AddmissionRulesService;
import uz.tashkec.education.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link uz.tashkec.education.domain.AddmissionRules}.
 */
@RestController
@RequestMapping("/api")
public class AddmissionRulesResource {

    private final Logger log = LoggerFactory.getLogger(AddmissionRulesResource.class);

    private static final String ENTITY_NAME = "addmissionRules";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AddmissionRulesService addmissionRulesService;

    private final AddmissionRulesRepository addmissionRulesRepository;

    public AddmissionRulesResource(AddmissionRulesService addmissionRulesService, AddmissionRulesRepository addmissionRulesRepository) {
        this.addmissionRulesService = addmissionRulesService;
        this.addmissionRulesRepository = addmissionRulesRepository;
    }

    /**
     * {@code POST  /addmission-rules} : Create a new addmissionRules.
     *
     * @param addmissionRules the addmissionRules to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new addmissionRules, or with status {@code 400 (Bad Request)} if the addmissionRules has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/addmission-rules")
    public ResponseEntity<AddmissionRules> createAddmissionRules(@Valid @RequestBody AddmissionRules addmissionRules)
        throws URISyntaxException {
        log.debug("REST request to save AddmissionRules : {}", addmissionRules);
        if (addmissionRules.getId() != null) {
            throw new BadRequestAlertException("A new addmissionRules cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AddmissionRules result = addmissionRulesService.save(addmissionRules);
        return ResponseEntity
            .created(new URI("/api/addmission-rules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /addmission-rules/:id} : Updates an existing addmissionRules.
     *
     * @param id the id of the addmissionRules to save.
     * @param addmissionRules the addmissionRules to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated addmissionRules,
     * or with status {@code 400 (Bad Request)} if the addmissionRules is not valid,
     * or with status {@code 500 (Internal Server Error)} if the addmissionRules couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/addmission-rules/{id}")
    public ResponseEntity<AddmissionRules> updateAddmissionRules(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody AddmissionRules addmissionRules
    ) throws URISyntaxException {
        log.debug("REST request to update AddmissionRules : {}, {}", id, addmissionRules);
        if (addmissionRules.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, addmissionRules.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!addmissionRulesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AddmissionRules result = addmissionRulesService.update(addmissionRules);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, addmissionRules.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /addmission-rules/:id} : Partial updates given fields of an existing addmissionRules, field will ignore if it is null
     *
     * @param id the id of the addmissionRules to save.
     * @param addmissionRules the addmissionRules to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated addmissionRules,
     * or with status {@code 400 (Bad Request)} if the addmissionRules is not valid,
     * or with status {@code 404 (Not Found)} if the addmissionRules is not found,
     * or with status {@code 500 (Internal Server Error)} if the addmissionRules couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/addmission-rules/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<AddmissionRules> partialUpdateAddmissionRules(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody AddmissionRules addmissionRules
    ) throws URISyntaxException {
        log.debug("REST request to partial update AddmissionRules partially : {}, {}", id, addmissionRules);
        if (addmissionRules.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, addmissionRules.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!addmissionRulesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AddmissionRules> result = addmissionRulesService.partialUpdate(addmissionRules);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, addmissionRules.getId().toString())
        );
    }

    /**
     * {@code GET  /addmission-rules} : get all the addmissionRules.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of addmissionRules in body.
     */
    @GetMapping("/addmission-rules")
    public List<AddmissionRules> getAllAddmissionRules() {
        log.debug("REST request to get all AddmissionRules");
        return addmissionRulesService.findAll();
    }

    /**
     * {@code GET  /addmission-rules/:id} : get the "id" addmissionRules.
     *
     * @param id the id of the addmissionRules to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the addmissionRules, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/addmission-rules/{id}")
    public ResponseEntity<AddmissionRules> getAddmissionRules(@PathVariable Long id) {
        log.debug("REST request to get AddmissionRules : {}", id);
        Optional<AddmissionRules> addmissionRules = addmissionRulesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(addmissionRules);
    }

    /**
     * {@code DELETE  /addmission-rules/:id} : delete the "id" addmissionRules.
     *
     * @param id the id of the addmissionRules to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/addmission-rules/{id}")
    public ResponseEntity<Void> deleteAddmissionRules(@PathVariable Long id) {
        log.debug("REST request to delete AddmissionRules : {}", id);
        addmissionRulesService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}

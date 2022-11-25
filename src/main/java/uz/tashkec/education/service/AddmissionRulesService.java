package uz.tashkec.education.service;

import java.util.List;
import java.util.Optional;
import uz.tashkec.education.domain.AddmissionRules;

/**
 * Service Interface for managing {@link AddmissionRules}.
 */
public interface AddmissionRulesService {
    /**
     * Save a addmissionRules.
     *
     * @param addmissionRules the entity to save.
     * @return the persisted entity.
     */
    AddmissionRules save(AddmissionRules addmissionRules);

    /**
     * Updates a addmissionRules.
     *
     * @param addmissionRules the entity to update.
     * @return the persisted entity.
     */
    AddmissionRules update(AddmissionRules addmissionRules);

    /**
     * Partially updates a addmissionRules.
     *
     * @param addmissionRules the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AddmissionRules> partialUpdate(AddmissionRules addmissionRules);

    /**
     * Get all the addmissionRules.
     *
     * @return the list of entities.
     */
    List<AddmissionRules> findAll();

    /**
     * Get the "id" addmissionRules.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AddmissionRules> findOne(Long id);

    /**
     * Delete the "id" addmissionRules.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

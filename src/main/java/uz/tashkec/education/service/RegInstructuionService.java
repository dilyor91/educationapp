package uz.tashkec.education.service;

import java.util.List;
import java.util.Optional;
import uz.tashkec.education.domain.RegInstructuion;

/**
 * Service Interface for managing {@link RegInstructuion}.
 */
public interface RegInstructuionService {
    /**
     * Save a regInstructuion.
     *
     * @param regInstructuion the entity to save.
     * @return the persisted entity.
     */
    RegInstructuion save(RegInstructuion regInstructuion);

    /**
     * Updates a regInstructuion.
     *
     * @param regInstructuion the entity to update.
     * @return the persisted entity.
     */
    RegInstructuion update(RegInstructuion regInstructuion);

    /**
     * Partially updates a regInstructuion.
     *
     * @param regInstructuion the entity to update partially.
     * @return the persisted entity.
     */
    Optional<RegInstructuion> partialUpdate(RegInstructuion regInstructuion);

    /**
     * Get all the regInstructuions.
     *
     * @return the list of entities.
     */
    List<RegInstructuion> findAll();

    /**
     * Get the "id" regInstructuion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RegInstructuion> findOne(Long id);

    /**
     * Delete the "id" regInstructuion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

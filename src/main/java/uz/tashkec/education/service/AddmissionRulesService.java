package uz.tashkec.education.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.tashkec.education.service.dto.AddmissionRulesDTO;

/**
 * Service Interface for managing {@link uz.tashkec.education.domain.AddmissionRules}.
 */
public interface AddmissionRulesService {
    /**
     * Save a addmissionRules.
     *
     * @param addmissionRulesDTO the entity to save.
     * @return the persisted entity.
     */
    AddmissionRulesDTO save(AddmissionRulesDTO addmissionRulesDTO);

    /**
     * Updates a addmissionRules.
     *
     * @param addmissionRulesDTO the entity to update.
     * @return the persisted entity.
     */
    AddmissionRulesDTO update(AddmissionRulesDTO addmissionRulesDTO);

    /**
     * Partially updates a addmissionRules.
     *
     * @param addmissionRulesDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AddmissionRulesDTO> partialUpdate(AddmissionRulesDTO addmissionRulesDTO);

    /**
     * Get all the addmissionRules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AddmissionRulesDTO> findAll(Pageable pageable);

    /**
     * Get the "id" addmissionRules.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AddmissionRulesDTO> findOne(Long id);

    /**
     * Delete the "id" addmissionRules.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

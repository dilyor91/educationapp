package uz.tashkec.education.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.tashkec.education.service.dto.TimetableDTO;

/**
 * Service Interface for managing {@link uz.tashkec.education.domain.Timetable}.
 */
public interface TimetableService {
    /**
     * Save a timetable.
     *
     * @param timetableDTO the entity to save.
     * @return the persisted entity.
     */
    TimetableDTO save(TimetableDTO timetableDTO);

    /**
     * Updates a timetable.
     *
     * @param timetableDTO the entity to update.
     * @return the persisted entity.
     */
    TimetableDTO update(TimetableDTO timetableDTO);

    /**
     * Partially updates a timetable.
     *
     * @param timetableDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TimetableDTO> partialUpdate(TimetableDTO timetableDTO);

    /**
     * Get all the timetables.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TimetableDTO> findAll(Pageable pageable);

    /**
     * Get the "id" timetable.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TimetableDTO> findOne(Long id);

    /**
     * Delete the "id" timetable.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

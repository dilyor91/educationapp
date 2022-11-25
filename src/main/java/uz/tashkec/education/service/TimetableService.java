package uz.tashkec.education.service;

import java.util.List;
import java.util.Optional;
import uz.tashkec.education.domain.Timetable;

/**
 * Service Interface for managing {@link Timetable}.
 */
public interface TimetableService {
    /**
     * Save a timetable.
     *
     * @param timetable the entity to save.
     * @return the persisted entity.
     */
    Timetable save(Timetable timetable);

    /**
     * Updates a timetable.
     *
     * @param timetable the entity to update.
     * @return the persisted entity.
     */
    Timetable update(Timetable timetable);

    /**
     * Partially updates a timetable.
     *
     * @param timetable the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Timetable> partialUpdate(Timetable timetable);

    /**
     * Get all the timetables.
     *
     * @return the list of entities.
     */
    List<Timetable> findAll();

    /**
     * Get the "id" timetable.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Timetable> findOne(Long id);

    /**
     * Delete the "id" timetable.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

package uz.tashkec.education.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import uz.tashkec.education.domain.Timetable;

/**
 * Spring Data JPA repository for the Timetable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {}

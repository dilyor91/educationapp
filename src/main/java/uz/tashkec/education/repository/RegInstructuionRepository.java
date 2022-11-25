package uz.tashkec.education.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import uz.tashkec.education.domain.RegInstructuion;

/**
 * Spring Data JPA repository for the RegInstructuion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegInstructuionRepository extends JpaRepository<RegInstructuion, Long> {}

package uz.tashkec.education.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import uz.tashkec.education.domain.AddmissionRules;

/**
 * Spring Data JPA repository for the AddmissionRules entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AddmissionRulesRepository extends JpaRepository<AddmissionRules, Long> {}

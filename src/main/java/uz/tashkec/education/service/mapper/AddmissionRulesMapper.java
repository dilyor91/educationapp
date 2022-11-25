package uz.tashkec.education.service.mapper;

import org.mapstruct.*;
import uz.tashkec.education.domain.AddmissionRules;
import uz.tashkec.education.service.dto.AddmissionRulesDTO;

/**
 * Mapper for the entity {@link AddmissionRules} and its DTO {@link AddmissionRulesDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddmissionRulesMapper extends EntityMapper<AddmissionRulesDTO, AddmissionRules> {}

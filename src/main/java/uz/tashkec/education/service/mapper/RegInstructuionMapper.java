package uz.tashkec.education.service.mapper;

import org.mapstruct.*;
import uz.tashkec.education.domain.RegInstructuion;
import uz.tashkec.education.service.dto.RegInstructuionDTO;

/**
 * Mapper for the entity {@link RegInstructuion} and its DTO {@link RegInstructuionDTO}.
 */
@Mapper(componentModel = "spring")
public interface RegInstructuionMapper extends EntityMapper<RegInstructuionDTO, RegInstructuion> {}

package uz.tashkec.education.service.mapper;

import org.mapstruct.*;
import uz.tashkec.education.domain.Timetable;
import uz.tashkec.education.service.dto.TimetableDTO;

/**
 * Mapper for the entity {@link Timetable} and its DTO {@link TimetableDTO}.
 */
@Mapper(componentModel = "spring")
public interface TimetableMapper extends EntityMapper<TimetableDTO, Timetable> {}

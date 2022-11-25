package uz.tashkec.education.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.education.domain.Timetable;
import uz.tashkec.education.repository.TimetableRepository;
import uz.tashkec.education.service.TimetableService;
import uz.tashkec.education.service.dto.TimetableDTO;
import uz.tashkec.education.service.mapper.TimetableMapper;

/**
 * Service Implementation for managing {@link Timetable}.
 */
@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

    private final Logger log = LoggerFactory.getLogger(TimetableServiceImpl.class);

    private final TimetableRepository timetableRepository;

    private final TimetableMapper timetableMapper;

    public TimetableServiceImpl(TimetableRepository timetableRepository, TimetableMapper timetableMapper) {
        this.timetableRepository = timetableRepository;
        this.timetableMapper = timetableMapper;
    }

    @Override
    public TimetableDTO save(TimetableDTO timetableDTO) {
        log.debug("Request to save Timetable : {}", timetableDTO);
        Timetable timetable = timetableMapper.toEntity(timetableDTO);
        timetable = timetableRepository.save(timetable);
        return timetableMapper.toDto(timetable);
    }

    @Override
    public TimetableDTO update(TimetableDTO timetableDTO) {
        log.debug("Request to update Timetable : {}", timetableDTO);
        Timetable timetable = timetableMapper.toEntity(timetableDTO);
        timetable = timetableRepository.save(timetable);
        return timetableMapper.toDto(timetable);
    }

    @Override
    public Optional<TimetableDTO> partialUpdate(TimetableDTO timetableDTO) {
        log.debug("Request to partially update Timetable : {}", timetableDTO);

        return timetableRepository
            .findById(timetableDTO.getId())
            .map(existingTimetable -> {
                timetableMapper.partialUpdate(existingTimetable, timetableDTO);

                return existingTimetable;
            })
            .map(timetableRepository::save)
            .map(timetableMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TimetableDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Timetables");
        return timetableRepository.findAll(pageable).map(timetableMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TimetableDTO> findOne(Long id) {
        log.debug("Request to get Timetable : {}", id);
        return timetableRepository.findById(id).map(timetableMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Timetable : {}", id);
        timetableRepository.deleteById(id);
    }
}

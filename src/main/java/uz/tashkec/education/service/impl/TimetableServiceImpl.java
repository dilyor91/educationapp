package uz.tashkec.education.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.education.domain.Timetable;
import uz.tashkec.education.repository.TimetableRepository;
import uz.tashkec.education.service.TimetableService;

/**
 * Service Implementation for managing {@link Timetable}.
 */
@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

    private final Logger log = LoggerFactory.getLogger(TimetableServiceImpl.class);

    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    @Override
    public Timetable save(Timetable timetable) {
        log.debug("Request to save Timetable : {}", timetable);
        return timetableRepository.save(timetable);
    }

    @Override
    public Timetable update(Timetable timetable) {
        log.debug("Request to update Timetable : {}", timetable);
        return timetableRepository.save(timetable);
    }

    @Override
    public Optional<Timetable> partialUpdate(Timetable timetable) {
        log.debug("Request to partially update Timetable : {}", timetable);

        return timetableRepository
            .findById(timetable.getId())
            .map(existingTimetable -> {
                if (timetable.getTitleUz() != null) {
                    existingTimetable.setTitleUz(timetable.getTitleUz());
                }
                if (timetable.getTitleRu() != null) {
                    existingTimetable.setTitleRu(timetable.getTitleRu());
                }
                if (timetable.getTitleKr() != null) {
                    existingTimetable.setTitleKr(timetable.getTitleKr());
                }
                if (timetable.getContentUz() != null) {
                    existingTimetable.setContentUz(timetable.getContentUz());
                }
                if (timetable.getContentRu() != null) {
                    existingTimetable.setContentRu(timetable.getContentRu());
                }
                if (timetable.getContentKr() != null) {
                    existingTimetable.setContentKr(timetable.getContentKr());
                }
                if (timetable.getStatus() != null) {
                    existingTimetable.setStatus(timetable.getStatus());
                }

                return existingTimetable;
            })
            .map(timetableRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timetable> findAll() {
        log.debug("Request to get all Timetables");
        return timetableRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Timetable> findOne(Long id) {
        log.debug("Request to get Timetable : {}", id);
        return timetableRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Timetable : {}", id);
        timetableRepository.deleteById(id);
    }
}

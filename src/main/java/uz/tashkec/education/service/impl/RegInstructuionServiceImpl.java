package uz.tashkec.education.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.education.domain.RegInstructuion;
import uz.tashkec.education.repository.RegInstructuionRepository;
import uz.tashkec.education.service.RegInstructuionService;

/**
 * Service Implementation for managing {@link RegInstructuion}.
 */
@Service
@Transactional
public class RegInstructuionServiceImpl implements RegInstructuionService {

    private final Logger log = LoggerFactory.getLogger(RegInstructuionServiceImpl.class);

    private final RegInstructuionRepository regInstructuionRepository;

    public RegInstructuionServiceImpl(RegInstructuionRepository regInstructuionRepository) {
        this.regInstructuionRepository = regInstructuionRepository;
    }

    @Override
    public RegInstructuion save(RegInstructuion regInstructuion) {
        log.debug("Request to save RegInstructuion : {}", regInstructuion);
        return regInstructuionRepository.save(regInstructuion);
    }

    @Override
    public RegInstructuion update(RegInstructuion regInstructuion) {
        log.debug("Request to update RegInstructuion : {}", regInstructuion);
        return regInstructuionRepository.save(regInstructuion);
    }

    @Override
    public Optional<RegInstructuion> partialUpdate(RegInstructuion regInstructuion) {
        log.debug("Request to partially update RegInstructuion : {}", regInstructuion);

        return regInstructuionRepository
            .findById(regInstructuion.getId())
            .map(existingRegInstructuion -> {
                if (regInstructuion.getTitleUz() != null) {
                    existingRegInstructuion.setTitleUz(regInstructuion.getTitleUz());
                }
                if (regInstructuion.getTitleRu() != null) {
                    existingRegInstructuion.setTitleRu(regInstructuion.getTitleRu());
                }
                if (regInstructuion.getTitleKr() != null) {
                    existingRegInstructuion.setTitleKr(regInstructuion.getTitleKr());
                }
                if (regInstructuion.getContentUz() != null) {
                    existingRegInstructuion.setContentUz(regInstructuion.getContentUz());
                }
                if (regInstructuion.getContentRu() != null) {
                    existingRegInstructuion.setContentRu(regInstructuion.getContentRu());
                }
                if (regInstructuion.getContentKr() != null) {
                    existingRegInstructuion.setContentKr(regInstructuion.getContentKr());
                }
                if (regInstructuion.getStatus() != null) {
                    existingRegInstructuion.setStatus(regInstructuion.getStatus());
                }

                return existingRegInstructuion;
            })
            .map(regInstructuionRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegInstructuion> findAll() {
        log.debug("Request to get all RegInstructuions");
        return regInstructuionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RegInstructuion> findOne(Long id) {
        log.debug("Request to get RegInstructuion : {}", id);
        return regInstructuionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RegInstructuion : {}", id);
        regInstructuionRepository.deleteById(id);
    }
}

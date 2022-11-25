package uz.tashkec.education.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.education.domain.AddmissionRules;
import uz.tashkec.education.repository.AddmissionRulesRepository;
import uz.tashkec.education.service.AddmissionRulesService;

/**
 * Service Implementation for managing {@link AddmissionRules}.
 */
@Service
@Transactional
public class AddmissionRulesServiceImpl implements AddmissionRulesService {

    private final Logger log = LoggerFactory.getLogger(AddmissionRulesServiceImpl.class);

    private final AddmissionRulesRepository addmissionRulesRepository;

    public AddmissionRulesServiceImpl(AddmissionRulesRepository addmissionRulesRepository) {
        this.addmissionRulesRepository = addmissionRulesRepository;
    }

    @Override
    public AddmissionRules save(AddmissionRules addmissionRules) {
        log.debug("Request to save AddmissionRules : {}", addmissionRules);
        return addmissionRulesRepository.save(addmissionRules);
    }

    @Override
    public AddmissionRules update(AddmissionRules addmissionRules) {
        log.debug("Request to update AddmissionRules : {}", addmissionRules);
        return addmissionRulesRepository.save(addmissionRules);
    }

    @Override
    public Optional<AddmissionRules> partialUpdate(AddmissionRules addmissionRules) {
        log.debug("Request to partially update AddmissionRules : {}", addmissionRules);

        return addmissionRulesRepository
            .findById(addmissionRules.getId())
            .map(existingAddmissionRules -> {
                if (addmissionRules.getTitleUz() != null) {
                    existingAddmissionRules.setTitleUz(addmissionRules.getTitleUz());
                }
                if (addmissionRules.getTitleRu() != null) {
                    existingAddmissionRules.setTitleRu(addmissionRules.getTitleRu());
                }
                if (addmissionRules.getTitleKr() != null) {
                    existingAddmissionRules.setTitleKr(addmissionRules.getTitleKr());
                }
                if (addmissionRules.getContentUz() != null) {
                    existingAddmissionRules.setContentUz(addmissionRules.getContentUz());
                }
                if (addmissionRules.getContentRu() != null) {
                    existingAddmissionRules.setContentRu(addmissionRules.getContentRu());
                }
                if (addmissionRules.getContentKr() != null) {
                    existingAddmissionRules.setContentKr(addmissionRules.getContentKr());
                }
                if (addmissionRules.getStatus() != null) {
                    existingAddmissionRules.setStatus(addmissionRules.getStatus());
                }

                return existingAddmissionRules;
            })
            .map(addmissionRulesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddmissionRules> findAll() {
        log.debug("Request to get all AddmissionRules");
        return addmissionRulesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AddmissionRules> findOne(Long id) {
        log.debug("Request to get AddmissionRules : {}", id);
        return addmissionRulesRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AddmissionRules : {}", id);
        addmissionRulesRepository.deleteById(id);
    }
}

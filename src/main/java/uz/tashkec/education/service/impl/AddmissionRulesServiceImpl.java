package uz.tashkec.education.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.education.domain.AddmissionRules;
import uz.tashkec.education.repository.AddmissionRulesRepository;
import uz.tashkec.education.service.AddmissionRulesService;
import uz.tashkec.education.service.dto.AddmissionRulesDTO;
import uz.tashkec.education.service.mapper.AddmissionRulesMapper;

/**
 * Service Implementation for managing {@link AddmissionRules}.
 */
@Service
@Transactional
public class AddmissionRulesServiceImpl implements AddmissionRulesService {

    private final Logger log = LoggerFactory.getLogger(AddmissionRulesServiceImpl.class);

    private final AddmissionRulesRepository addmissionRulesRepository;

    private final AddmissionRulesMapper addmissionRulesMapper;

    public AddmissionRulesServiceImpl(AddmissionRulesRepository addmissionRulesRepository, AddmissionRulesMapper addmissionRulesMapper) {
        this.addmissionRulesRepository = addmissionRulesRepository;
        this.addmissionRulesMapper = addmissionRulesMapper;
    }

    @Override
    public AddmissionRulesDTO save(AddmissionRulesDTO addmissionRulesDTO) {
        log.debug("Request to save AddmissionRules : {}", addmissionRulesDTO);
        AddmissionRules addmissionRules = addmissionRulesMapper.toEntity(addmissionRulesDTO);
        addmissionRules = addmissionRulesRepository.save(addmissionRules);
        return addmissionRulesMapper.toDto(addmissionRules);
    }

    @Override
    public AddmissionRulesDTO update(AddmissionRulesDTO addmissionRulesDTO) {
        log.debug("Request to update AddmissionRules : {}", addmissionRulesDTO);
        AddmissionRules addmissionRules = addmissionRulesMapper.toEntity(addmissionRulesDTO);
        addmissionRules = addmissionRulesRepository.save(addmissionRules);
        return addmissionRulesMapper.toDto(addmissionRules);
    }

    @Override
    public Optional<AddmissionRulesDTO> partialUpdate(AddmissionRulesDTO addmissionRulesDTO) {
        log.debug("Request to partially update AddmissionRules : {}", addmissionRulesDTO);

        return addmissionRulesRepository
            .findById(addmissionRulesDTO.getId())
            .map(existingAddmissionRules -> {
                addmissionRulesMapper.partialUpdate(existingAddmissionRules, addmissionRulesDTO);

                return existingAddmissionRules;
            })
            .map(addmissionRulesRepository::save)
            .map(addmissionRulesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AddmissionRulesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AddmissionRules");
        return addmissionRulesRepository.findAll(pageable).map(addmissionRulesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AddmissionRulesDTO> findOne(Long id) {
        log.debug("Request to get AddmissionRules : {}", id);
        return addmissionRulesRepository.findById(id).map(addmissionRulesMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AddmissionRules : {}", id);
        addmissionRulesRepository.deleteById(id);
    }
}

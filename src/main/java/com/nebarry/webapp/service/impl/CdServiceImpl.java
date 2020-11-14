package com.nebarry.webapp.service.impl;

import com.nebarry.webapp.service.CdService;
import com.nebarry.webapp.domain.Cd;
import com.nebarry.webapp.repository.CdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Cd}.
 */
@Service
public class CdServiceImpl implements CdService {

    private final Logger log = LoggerFactory.getLogger(CdServiceImpl.class);

    private final CdRepository cdRepository;

    public CdServiceImpl(CdRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    @Override
    public Cd save(Cd cd) {
        log.debug("Request to save Cd : {}", cd);
        return cdRepository.save(cd);
    }

    @Override
    public Page<Cd> findAll(Pageable pageable) {
        log.debug("Request to get all Cds");
        return cdRepository.findAll(pageable);
    }


    @Override
    public Optional<Cd> findOne(String id) {
        log.debug("Request to get Cd : {}", id);
        return cdRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Cd : {}", id);
        cdRepository.deleteById(id);
    }
}

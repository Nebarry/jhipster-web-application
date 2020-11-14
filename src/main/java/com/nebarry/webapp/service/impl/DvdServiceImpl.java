package com.nebarry.webapp.service.impl;

import com.nebarry.webapp.service.DvdService;
import com.nebarry.webapp.domain.Dvd;
import com.nebarry.webapp.repository.DvdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Dvd}.
 */
@Service
public class DvdServiceImpl implements DvdService {

    private final Logger log = LoggerFactory.getLogger(DvdServiceImpl.class);

    private final DvdRepository dvdRepository;

    public DvdServiceImpl(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    @Override
    public Dvd save(Dvd dvd) {
        log.debug("Request to save Dvd : {}", dvd);
        return dvdRepository.save(dvd);
    }

    @Override
    public Page<Dvd> findAll(Pageable pageable) {
        log.debug("Request to get all Dvds");
        return dvdRepository.findAll(pageable);
    }


    @Override
    public Optional<Dvd> findOne(String id) {
        log.debug("Request to get Dvd : {}", id);
        return dvdRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Dvd : {}", id);
        dvdRepository.deleteById(id);
    }
}

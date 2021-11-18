package com.chunkiechunks.service;

import com.chunkiechunks.domain.Practice;
import com.chunkiechunks.service.dto.PracticeDTO;
import com.chunkiechunks.service.mapper.PracticeMapper;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PracticeService {

    private final Logger log = LoggerFactory.getLogger(PracticeService.class);

    private final PracticeMapper practiceMapper;

    @Inject
    public PracticeService(PracticeMapper practiceMapper) {
        this.practiceMapper = practiceMapper;
    }

    public Paged<PracticeDTO> getAllPaginatedPracticesBySubFamilyId(Sort sort, Page page, Long subFamilyId) {
        log.debug("Request to get all Practices with Sub Family ID: {}", subFamilyId);
        return new Paged<>(Practice.findAllPaginatedPracticesBySubFamilyId(sort, page, subFamilyId))
            .map(practiceMapper::toDto);
    }

    public Paged<PracticeDTO> getAllPaginatedPracticesByFamilyId(Sort sort, Page page, Long familyId) {
        log.debug("Request to get all Practices with Family ID: {}", familyId);
        return new Paged<>(Practice.findAllPaginatedPracticesByFamilyId(sort, page, familyId))
            .map(practiceMapper::toDto);
    }
}

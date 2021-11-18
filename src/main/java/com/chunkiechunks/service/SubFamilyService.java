package com.chunkiechunks.service;

import com.chunkiechunks.domain.SubFamily;
import com.chunkiechunks.service.dto.SubFamilyDTO;
import com.chunkiechunks.service.mapper.SubFamilyMapper;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class SubFamilyService {

    private final Logger log = LoggerFactory.getLogger(SubFamilyService.class);

    private final SubFamilyMapper subFamilyMapper;

    @Inject
    public SubFamilyService(SubFamilyMapper subFamilyMapper) {
        this.subFamilyMapper = subFamilyMapper;
    }

    public Optional<SubFamily> findSubFamilyById(Long id) {
        return SubFamily.findByIdOptional(id);
    }

    public Paged<SubFamilyDTO> getAllPaginatedSubFamiliesByFamilyId(Sort sort, Page page, Long familyId) {
        log.debug("Request to get all Sub Families with Family ID: {}", familyId);
        return new Paged<>(SubFamily.findAllPaginatedSubFamiliesByFamilyId(sort, page, familyId))
            .map(subFamilyMapper::toDto);
    }
}

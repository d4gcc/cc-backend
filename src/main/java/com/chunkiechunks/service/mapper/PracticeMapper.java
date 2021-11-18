package com.chunkiechunks.service.mapper;


import com.chunkiechunks.domain.Practice;
import com.chunkiechunks.service.dto.PracticeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Practice} and its DTO {@link PracticeDTO}.
 */
@Mapper(componentModel = "cdi", uses = {})
public interface PracticeMapper extends EntityMapper<PracticeDTO, Practice> {

    @Mapping(source = "formalType.name", target = "formalType")
    PracticeDTO toDto(Practice entity);

    default Practice fromId(Long id) {
        if (id == null) {
            return null;
        }
        Practice practice = new Practice();
        practice.setId(id);
        return practice;
    }
}

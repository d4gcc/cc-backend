package com.chunkiechunks.service.mapper;


import com.chunkiechunks.domain.SubFamily;
import com.chunkiechunks.service.dto.SubFamilyDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link SubFamily} and its DTO {@link SubFamilyDTO}.
 */
@Mapper(componentModel = "cdi", uses = {})
public interface SubFamilyMapper extends EntityMapper<SubFamilyDTO, SubFamily> {

    default SubFamily fromId(Long id) {
        if (id == null) {
            return null;
        }
        SubFamily subFamily = new SubFamily();
        subFamily.setId(id);
        return subFamily;
    }
}

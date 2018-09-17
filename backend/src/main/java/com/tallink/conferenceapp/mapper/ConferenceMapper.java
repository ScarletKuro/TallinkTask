package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses=EntityMapper.class)
public interface ConferenceMapper {
    @Mapping(source="conferenceRoom", target="roomId")
    ConferenceDTO toDTO(ConferenceEntity conference);

    @InheritInverseConfiguration
    ConferenceEntity toEntity(ConferenceDTO conferenceDTO);

    void mapToEntity(ConferenceDTO conferenceDTO, @MappingTarget ConferenceEntity conference);
}

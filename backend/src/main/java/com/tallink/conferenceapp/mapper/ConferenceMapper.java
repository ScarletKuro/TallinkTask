package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses=EntityMapper.class)
public interface ConferenceMapper {
    @Mapping(source="conferenceRoom", target="roomId")
    public ConferenceDTO toDTO(ConferenceEntity conference);

    @InheritInverseConfiguration
    public ConferenceEntity toEntity(ConferenceDTO conferenceDTO);

    public void mapToEntity(ConferenceDTO conferenceDTO, @MappingTarget ConferenceEntity conference);
}

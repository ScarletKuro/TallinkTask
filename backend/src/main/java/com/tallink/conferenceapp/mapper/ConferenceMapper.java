package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses=EntityMapper.class)
public interface ConferenceMapper {
    @Mapping(source="conferenceRoom", target="roomId")
    public ConferenceDTO toDTO(ConferenceEntity conference);

    @InheritInverseConfiguration
    public ConferenceEntity toEntity(ConferenceDTO conferenceDTO);

    //public ConferenceRoomDTO toDTO(ConferenceRoomEntity roomEntity);

    //public ConferenceRoomEntity toEntity(ConferenceRoomDTO conferenceRoomDTO);

    public void mapToEntity(ConferenceDTO conferenceDTO, @MappingTarget ConferenceEntity conference);
}

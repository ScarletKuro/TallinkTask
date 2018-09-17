package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ConferenceMapper.class})
public interface ConferenceRoomMapper {
    ConferenceRoomDTO toDTO(ConferenceRoomEntity conferenceRoom);

    ConferenceRoomEntity toEntity(ConferenceRoomDTO conferenceRoomDTO);

    void mapToEntity(ConferenceRoomDTO conferenceRoomDTO, @MappingTarget ConferenceRoomEntity conferenceRoom);
}

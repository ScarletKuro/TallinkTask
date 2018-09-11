package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ConferenceMapper.class})
public interface ConferenceRoomMapper {
    public ConferenceRoomDTO toDTO(ConferenceRoomEntity conferenceRoom);

    public ConferenceRoomEntity toEntity(ConferenceRoomDTO conferenceRoomDTO);

    public void mapToEntity(ConferenceRoomDTO conferenceRoomDTO, @MappingTarget ConferenceRoomEntity conferenceRoom);
}

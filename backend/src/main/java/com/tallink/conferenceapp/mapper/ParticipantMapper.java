package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.model.ParticipantEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParticipantMapper {
    public ParticipantDTO toDTO(ParticipantEntity participant);

    public ParticipantEntity toEntity(ParticipantDTO participantDTO);

    public void mapToEntity(ParticipantDTO participantDTO, @MappingTarget ParticipantEntity participant);
}

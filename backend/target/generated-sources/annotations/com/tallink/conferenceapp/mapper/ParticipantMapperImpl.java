package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.model.ParticipantEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-13T04:07:44+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class ParticipantMapperImpl implements ParticipantMapper {

    @Override
    public ParticipantDTO toDTO(ParticipantEntity participant) {
        if ( participant == null ) {
            return null;
        }

        ParticipantDTO participantDTO = new ParticipantDTO();

        participantDTO.id = participant.id;
        participantDTO.participantName = participant.participantName;
        participantDTO.participantBirthDay = participant.participantBirthDay;

        return participantDTO;
    }

    @Override
    public ParticipantEntity toEntity(ParticipantDTO participantDTO) {
        if ( participantDTO == null ) {
            return null;
        }

        ParticipantEntity participantEntity = new ParticipantEntity();

        participantEntity.id = participantDTO.id;
        participantEntity.participantName = participantDTO.participantName;
        participantEntity.participantBirthDay = participantDTO.participantBirthDay;

        return participantEntity;
    }

    @Override
    public void mapToEntity(ParticipantDTO participantDTO, ParticipantEntity participant) {
        if ( participantDTO == null ) {
            return;
        }

        participant.id = participantDTO.id;
        participant.participantName = participantDTO.participantName;
        participant.participantBirthDay = participantDTO.participantBirthDay;
    }
}

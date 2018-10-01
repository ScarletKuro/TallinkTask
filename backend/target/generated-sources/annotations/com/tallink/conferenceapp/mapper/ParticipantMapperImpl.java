package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.model.ParticipantEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-01T17:29:30+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_91 (Oracle Corporation)"
)
@Component
public class ParticipantMapperImpl implements ParticipantMapper {

    @Override
    public ParticipantDTO toDTO(ParticipantEntity participant) {
        if ( participant == null ) {
            return null;
        }

        ParticipantDTO participantDTO = new ParticipantDTO();

        participantDTO.setId( participant.getId() );
        participantDTO.setParticipantName( participant.getParticipantName() );
        participantDTO.setParticipantBirthDay( participant.getParticipantBirthDay() );

        return participantDTO;
    }

    @Override
    public ParticipantEntity toEntity(ParticipantDTO participantDTO) {
        if ( participantDTO == null ) {
            return null;
        }

        ParticipantEntity participantEntity = new ParticipantEntity();

        participantEntity.setId( participantDTO.getId() );
        participantEntity.setParticipantName( participantDTO.getParticipantName() );
        participantEntity.setParticipantBirthDay( participantDTO.getParticipantBirthDay() );

        return participantEntity;
    }

    @Override
    public void mapToEntity(ParticipantDTO participantDTO, ParticipantEntity participant) {
        if ( participantDTO == null ) {
            return;
        }

        participant.setId( participantDTO.getId() );
        participant.setParticipantName( participantDTO.getParticipantName() );
        participant.setParticipantBirthDay( participantDTO.getParticipantBirthDay() );
    }
}

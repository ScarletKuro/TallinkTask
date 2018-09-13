package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ParticipantEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-13T04:07:45+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class ConferenceMapperImpl implements ConferenceMapper {

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public ConferenceDTO toDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        ConferenceDTO conferenceDTO = new ConferenceDTO();

        conferenceDTO.roomId = entityMapper.toReference( conference.getConferenceRoom() );
        conferenceDTO.id = conference.id;
        conferenceDTO.conferenceName = conference.conferenceName;
        conferenceDTO.conferenceDateTime = conference.conferenceDateTime;
        conferenceDTO.participants = participantEntityListToParticipantDTOList( conference.participants );

        return conferenceDTO;
    }

    @Override
    public ConferenceEntity toEntity(ConferenceDTO conferenceDTO) {
        if ( conferenceDTO == null ) {
            return null;
        }

        ConferenceEntity conferenceEntity = new ConferenceEntity();

        if ( conferenceDTO.roomId != null ) {
            conferenceEntity.setConferenceRoom( entityMapper.toReference( conferenceDTO.roomId.longValue() ) );
        }
        conferenceEntity.id = conferenceDTO.id;
        conferenceEntity.conferenceName = conferenceDTO.conferenceName;
        conferenceEntity.conferenceDateTime = conferenceDTO.conferenceDateTime;
        conferenceEntity.participants = participantDTOListToParticipantEntityList( conferenceDTO.participants );

        return conferenceEntity;
    }

    @Override
    public void mapToEntity(ConferenceDTO conferenceDTO, ConferenceEntity conference) {
        if ( conferenceDTO == null ) {
            return;
        }

        conference.id = conferenceDTO.id;
        conference.conferenceName = conferenceDTO.conferenceName;
        conference.conferenceDateTime = conferenceDTO.conferenceDateTime;
        if ( conference.participants != null ) {
            List<ParticipantEntity> list = participantDTOListToParticipantEntityList( conferenceDTO.participants );
            if ( list != null ) {
                conference.participants.clear();
                conference.participants.addAll( list );
            }
            else {
                conference.participants = null;
            }
        }
        else {
            List<ParticipantEntity> list = participantDTOListToParticipantEntityList( conferenceDTO.participants );
            if ( list != null ) {
                conference.participants = list;
            }
        }
    }

    protected ParticipantDTO participantEntityToParticipantDTO(ParticipantEntity participantEntity) {
        if ( participantEntity == null ) {
            return null;
        }

        ParticipantDTO participantDTO = new ParticipantDTO();

        participantDTO.id = participantEntity.id;
        participantDTO.participantName = participantEntity.participantName;
        participantDTO.participantBirthDay = participantEntity.participantBirthDay;

        return participantDTO;
    }

    protected List<ParticipantDTO> participantEntityListToParticipantDTOList(List<ParticipantEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ParticipantDTO> list1 = new ArrayList<ParticipantDTO>( list.size() );
        for ( ParticipantEntity participantEntity : list ) {
            list1.add( participantEntityToParticipantDTO( participantEntity ) );
        }

        return list1;
    }

    protected ParticipantEntity participantDTOToParticipantEntity(ParticipantDTO participantDTO) {
        if ( participantDTO == null ) {
            return null;
        }

        ParticipantEntity participantEntity = new ParticipantEntity();

        participantEntity.id = participantDTO.id;
        participantEntity.participantName = participantDTO.participantName;
        participantEntity.participantBirthDay = participantDTO.participantBirthDay;

        return participantEntity;
    }

    protected List<ParticipantEntity> participantDTOListToParticipantEntityList(List<ParticipantDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ParticipantEntity> list1 = new ArrayList<ParticipantEntity>( list.size() );
        for ( ParticipantDTO participantDTO : list ) {
            list1.add( participantDTOToParticipantEntity( participantDTO ) );
        }

        return list1;
    }
}

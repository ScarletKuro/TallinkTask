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
    date = "2018-09-17T23:08:20+0300",
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

        conferenceDTO.setRoomId( entityMapper.toReference( conference.getConferenceRoom() ) );
        conferenceDTO.setId( conference.getId() );
        conferenceDTO.setConferenceName( conference.getConferenceName() );
        conferenceDTO.setConferenceDateTime( conference.getConferenceDateTime() );
        conferenceDTO.setParticipants( participantEntityListToParticipantDTOList( conference.getParticipants() ) );

        return conferenceDTO;
    }

    @Override
    public ConferenceEntity toEntity(ConferenceDTO conferenceDTO) {
        if ( conferenceDTO == null ) {
            return null;
        }

        ConferenceEntity conferenceEntity = new ConferenceEntity();

        if ( conferenceDTO.getRoomId() != null ) {
            conferenceEntity.setConferenceRoom( entityMapper.toReference( conferenceDTO.getRoomId().longValue() ) );
        }
        conferenceEntity.setId( conferenceDTO.getId() );
        conferenceEntity.setConferenceName( conferenceDTO.getConferenceName() );
        conferenceEntity.setConferenceDateTime( conferenceDTO.getConferenceDateTime() );
        conferenceEntity.setParticipants( participantDTOListToParticipantEntityList( conferenceDTO.getParticipants() ) );

        return conferenceEntity;
    }

    @Override
    public void mapToEntity(ConferenceDTO conferenceDTO, ConferenceEntity conference) {
        if ( conferenceDTO == null ) {
            return;
        }

        conference.setId( conferenceDTO.getId() );
        conference.setConferenceName( conferenceDTO.getConferenceName() );
        conference.setConferenceDateTime( conferenceDTO.getConferenceDateTime() );
        if ( conference.getParticipants() != null ) {
            List<ParticipantEntity> list = participantDTOListToParticipantEntityList( conferenceDTO.getParticipants() );
            if ( list != null ) {
                conference.getParticipants().clear();
                conference.getParticipants().addAll( list );
            }
            else {
                conference.setParticipants( null );
            }
        }
        else {
            List<ParticipantEntity> list = participantDTOListToParticipantEntityList( conferenceDTO.getParticipants() );
            if ( list != null ) {
                conference.setParticipants( list );
            }
        }
    }

    protected ParticipantDTO participantEntityToParticipantDTO(ParticipantEntity participantEntity) {
        if ( participantEntity == null ) {
            return null;
        }

        ParticipantDTO participantDTO = new ParticipantDTO();

        participantDTO.setId( participantEntity.getId() );
        participantDTO.setParticipantName( participantEntity.getParticipantName() );
        participantDTO.setParticipantBirthDay( participantEntity.getParticipantBirthDay() );

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

        participantEntity.setId( participantDTO.getId() );
        participantEntity.setParticipantName( participantDTO.getParticipantName() );
        participantEntity.setParticipantBirthDay( participantDTO.getParticipantBirthDay() );

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

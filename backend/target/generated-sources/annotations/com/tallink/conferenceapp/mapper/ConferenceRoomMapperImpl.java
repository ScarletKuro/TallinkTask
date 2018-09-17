package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
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
public class ConferenceRoomMapperImpl implements ConferenceRoomMapper {

    @Autowired
    private ConferenceMapper conferenceMapper;

    @Override
    public ConferenceRoomDTO toDTO(ConferenceRoomEntity conferenceRoom) {
        if ( conferenceRoom == null ) {
            return null;
        }

        ConferenceRoomDTO conferenceRoomDTO = new ConferenceRoomDTO();

        conferenceRoomDTO.setId( conferenceRoom.getId() );
        conferenceRoomDTO.setConferences( conferenceEntityListToConferenceDTOList( conferenceRoom.getConferences() ) );
        conferenceRoomDTO.setRoomName( conferenceRoom.getRoomName() );
        conferenceRoomDTO.setSeats( conferenceRoom.getSeats() );
        conferenceRoomDTO.setLocation( conferenceRoom.getLocation() );

        return conferenceRoomDTO;
    }

    @Override
    public ConferenceRoomEntity toEntity(ConferenceRoomDTO conferenceRoomDTO) {
        if ( conferenceRoomDTO == null ) {
            return null;
        }

        ConferenceRoomEntity conferenceRoomEntity = new ConferenceRoomEntity();

        conferenceRoomEntity.setId( conferenceRoomDTO.getId() );
        conferenceRoomEntity.setRoomName( conferenceRoomDTO.getRoomName() );
        conferenceRoomEntity.setLocation( conferenceRoomDTO.getLocation() );
        conferenceRoomEntity.setSeats( conferenceRoomDTO.getSeats() );
        conferenceRoomEntity.setConferences( conferenceDTOListToConferenceEntityList( conferenceRoomDTO.getConferences() ) );

        return conferenceRoomEntity;
    }

    @Override
    public void mapToEntity(ConferenceRoomDTO conferenceRoomDTO, ConferenceRoomEntity conferenceRoom) {
        if ( conferenceRoomDTO == null ) {
            return;
        }

        conferenceRoom.setId( conferenceRoomDTO.getId() );
        conferenceRoom.setRoomName( conferenceRoomDTO.getRoomName() );
        conferenceRoom.setLocation( conferenceRoomDTO.getLocation() );
        conferenceRoom.setSeats( conferenceRoomDTO.getSeats() );
        if ( conferenceRoom.getConferences() != null ) {
            List<ConferenceEntity> list = conferenceDTOListToConferenceEntityList( conferenceRoomDTO.getConferences() );
            if ( list != null ) {
                conferenceRoom.getConferences().clear();
                conferenceRoom.getConferences().addAll( list );
            }
            else {
                conferenceRoom.setConferences( null );
            }
        }
        else {
            List<ConferenceEntity> list = conferenceDTOListToConferenceEntityList( conferenceRoomDTO.getConferences() );
            if ( list != null ) {
                conferenceRoom.setConferences( list );
            }
        }
    }

    protected List<ConferenceDTO> conferenceEntityListToConferenceDTOList(List<ConferenceEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ConferenceDTO> list1 = new ArrayList<ConferenceDTO>( list.size() );
        for ( ConferenceEntity conferenceEntity : list ) {
            list1.add( conferenceMapper.toDTO( conferenceEntity ) );
        }

        return list1;
    }

    protected List<ConferenceEntity> conferenceDTOListToConferenceEntityList(List<ConferenceDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ConferenceEntity> list1 = new ArrayList<ConferenceEntity>( list.size() );
        for ( ConferenceDTO conferenceDTO : list ) {
            list1.add( conferenceMapper.toEntity( conferenceDTO ) );
        }

        return list1;
    }
}

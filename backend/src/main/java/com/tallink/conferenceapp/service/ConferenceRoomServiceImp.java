package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.mapper.ConferenceMapper;
import com.tallink.conferenceapp.mapper.ConferenceRoomMapper;
import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import com.tallink.conferenceapp.model.ParticipantEntity;
import com.tallink.conferenceapp.repository.ConferenceRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Component("ConferenceRoomServiceImp")
public class ConferenceRoomServiceImp implements ConferenceRoomService {
    @Autowired
    ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    ConferenceRoomMapper conferenceRoomMapper;

    @Autowired
    ConferenceMapper conferenceMapper;

    @Override
    public Page<ConferenceRoomDTO> findRooms(Pageable pageable) {
        return this.conferenceRoomRepository.findAll(pageable).map(conferenceRoomMapper::toDTO);
    }

    @Override
    public Optional<ConferenceRoomDTO> getRoom(Long id) {
        return this.conferenceRoomRepository.findById(id).map(this.conferenceRoomMapper::toDTO);
    }

    @Override
    public void updateRoom(ConferenceRoomDTO roomDTO) {
//        ConferenceRoomEntity conferenceRoomEntity = this.conferenceRoomRepository.getOne(roomDTO.id);
//        conferenceRoomEntity.location = roomDTO.location;
//        conferenceRoomEntity.roomName = roomDTO.roomName;
//        conferenceRoomEntity.seats = roomDTO.seats;
//        List<ConferenceEntity> conferenceEntities = new ArrayList<>();
//        for (ConferenceDTO conferenceDTO : roomDTO.conferences){
//            ConferenceEntity conferenceEntity =  new ConferenceEntity();
//            List<ParticipantEntity> participantEntities = new ArrayList<>();
//            for (ParticipantDTO participantDTO : conferenceDTO.participants){
//                ParticipantEntity participantEntity = new ParticipantEntity(participantDTO.participantName, participantDTO.participantBirthDay);
//                participantEntity.id = participantDTO.id;
//                participantEntities.add(participantEntity);
//
//            }
//            conferenceEntity.participants = participantEntities;
//            conferenceEntity.conferenceDateTime = conferenceDTO.conferenceDateTime;
//            conferenceEntity.conferenceName = conferenceDTO.conferenceName;
//        }
//        conferenceRoomEntity.conferences = conferenceEntities;
//        this.conferenceRoomRepository.save(conferenceRoomEntity);
    }

    @Override
    public Page<ConferenceDTO> findAllConferences(Long id, Pageable pageable){
        return this.conferenceRoomRepository.findAllConferencesByRoomId(id, pageable).map(this.conferenceMapper::toDTO);
    }

    @Override
    public Optional<ConferenceDTO> getConference(Long roomId, Long conferenceId) {
        return this.conferenceRoomRepository.findConferenceByConferenceIdAndRoomId(roomId, conferenceId).map(this.conferenceMapper::toDTO);
    }


    @Override
    public void saveRoom(ConferenceRoomDTO roomDTO) {
        ConferenceRoomEntity conferenceRoomEntity = this.conferenceRoomMapper.toEntity(roomDTO);
        this.conferenceRoomRepository.saveAndFlush(conferenceRoomEntity);
    }

    @Override
    public void deleteRoom(Long id) {
        this.conferenceRoomRepository.delete(id);
    }
}

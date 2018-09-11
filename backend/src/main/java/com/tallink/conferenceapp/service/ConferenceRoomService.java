package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConferenceRoomService {
    Page<ConferenceRoomDTO> findRooms(Pageable pageable);

    Optional<ConferenceRoomDTO> getRoom(Long id);

    void saveRoom(ConferenceRoomDTO roomDTO);

    void deleteRoom(Long id);

    Page<ConferenceDTO> findAllConferences(Long id, Pageable pageable);

    Optional<ConferenceDTO> getConference(Long conferenceId, Long roomId);
}

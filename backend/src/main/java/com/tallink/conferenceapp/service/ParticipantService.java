package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.dto.ParticipantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParticipantService {
    Page<ParticipantDTO> findParticipant(Pageable pageable);

    Optional<ParticipantDTO> getParticipant(Long id);

    void saveParticipant(ParticipantDTO participantDTO);

    void deleteParticipant(Long id);
}

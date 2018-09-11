package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ConferenceService {
    Optional<ConferenceDTO> getConference(Long id);

    void saveConference(ConferenceDTO personDTO);

    Page<ConferenceDTO> findConferences(Pageable pageable);

    void deleteConference(Long id);

}

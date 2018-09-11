package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.mapper.ParticipantMapper;
import com.tallink.conferenceapp.model.ParticipantEntity;
import com.tallink.conferenceapp.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Component("ParticipantServiceImp")
public class ParticipantServiceImp implements ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    ParticipantMapper participantMapper;

    @Override
    public Page<ParticipantDTO> findParticipant(Pageable pageable) {
        return this.participantRepository.findAll(pageable).map(this.participantMapper::toDTO);
    }

    @Override
    public Optional<ParticipantDTO> getParticipant(Long id) {
        return this.participantRepository.findById(id).map(this.participantMapper::toDTO);
    }

    @Override
    public void saveParticipant(ParticipantDTO participantDTO) {
        ParticipantEntity participantEntity = this.participantMapper.toEntity(participantDTO);
        this.participantRepository.saveAndFlush(participantEntity);
    }

    @Override
    public void deleteParticipant(Long id) {
        this.participantRepository.delete(id);
    }
}

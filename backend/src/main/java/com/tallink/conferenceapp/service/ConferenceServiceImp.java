package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.mapper.ConferenceMapper;
import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Component("ConferenceServiceImp")
public class ConferenceServiceImp implements ConferenceService {
    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    ConferenceMapper conferenceMapper;

    @Override
    public Optional<ConferenceDTO> getConference(Long id) {
        return this.conferenceRepository.findById(id).map(this.conferenceMapper::toDTO);
    }

    @Override
    public void saveConference(ConferenceDTO conferenceDTO) {
        ConferenceEntity conferenceEntity = this.conferenceMapper.toEntity(conferenceDTO);
        this.conferenceRepository.saveAndFlush(conferenceEntity);
    }

    @Override
    public Page<ConferenceDTO> findConferences(Pageable pageable) {
        return this.conferenceRepository.findAll(pageable).map(this.conferenceMapper::toDTO);
    }

    @Override
    public void deleteConference(Long id) {
        this.conferenceRepository.delete(id);
        //ConferenceEntity conferenceEntity = this.conferenceRepository.findOne(id);
        //if (conferenceEntity != null){
        //    this.conferenceRepository.delete(conferenceEntity);
        //}
        //this.conferenceRepository.delete(id);
    }

}

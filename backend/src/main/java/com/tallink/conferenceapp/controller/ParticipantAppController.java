package com.tallink.conferenceapp.controller;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.service.ConferenceRoomService;
import com.tallink.conferenceapp.service.ConferenceService;
import com.tallink.conferenceapp.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/public/participant")
public class ParticipantAppController {
    @Autowired
    @Qualifier("ParticipantServiceImp")
    ParticipantService participantService;

    @Autowired
    @Qualifier("ConferenceServiceImp")
    ConferenceService conferenceService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ParticipantDTO> getParticipant(@PathVariable Long id) {
        return this.participantService.getParticipant(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<Page<ParticipantDTO>> getAllPParticipant(Pageable pageable){
        Page<ParticipantDTO> page = this.participantService.findParticipant(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/conference/{conferenceId}",method = RequestMethod.POST)
    public void createParticipant(@RequestBody ParticipantDTO participantDTO, @PathVariable Long conferenceId) {
        Optional<ConferenceDTO> conferenceDTO = this.conferenceService.getConference(conferenceId);
        if (conferenceDTO.isPresent()){
            conferenceDTO.get().participants.add(participantDTO);
            this.conferenceService.saveConference(conferenceDTO.get());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteParticipant(@PathVariable Long id) {
        this.participantService.deleteParticipant(id);
    }
}

package com.tallink.conferenceapp.controller;

import com.tallink.conferenceapp.dto.ConferenceDTO;
import com.tallink.conferenceapp.dto.ConferenceRoomDTO;
import com.tallink.conferenceapp.service.ConferenceRoomService;
import com.tallink.conferenceapp.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/public/room")
public class ConferenceAppController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/{roomId}/conferences/{conferenceId}", method = RequestMethod.GET)
    public ResponseEntity<ConferenceDTO> getConference(@PathVariable Long roomId, @PathVariable Long conferenceId) {
        return this.conferenceRoomService.getConference(roomId, conferenceId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
    public ResponseEntity<ConferenceRoomDTO> getRoom(@PathVariable Long roomId)
    {
        return this.conferenceRoomService.getRoom(roomId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }
    @RequestMapping(value = "/{roomId}/conferences", method = RequestMethod.GET)
    public ResponseEntity<Page<ConferenceDTO>> getAllConferences(@PathVariable Long roomId, Pageable pageable) {
        Page<ConferenceDTO> page = this.conferenceRoomService.findAllConferences(roomId, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<ConferenceRoomDTO>> getRooms(Pageable pageable) {
        Page<ConferenceRoomDTO> page = this.conferenceRoomService.findRooms(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addRoom(@RequestBody ConferenceRoomDTO conferenceRoomDTO){
        this.conferenceRoomService.saveRoom(conferenceRoomDTO);
    }

    @RequestMapping(value = "/{roomId}/conferences/", method = RequestMethod.POST)
    public void addConference(@RequestBody ConferenceDTO conferenceDTO, @PathVariable Long roomId){
        if (conferenceDTO.getRoomId().equals(roomId)){
            this.conferenceService.saveConference(conferenceDTO);
        }
    }

    @RequestMapping(value = "/{roomId}", method = RequestMethod.DELETE)
    public void removeRoom(@PathVariable Long roomId){
        Optional<ConferenceRoomDTO> conferenceRoomEntity = this.conferenceRoomService.getRoom(roomId);
        if (conferenceRoomEntity.isPresent()) {
            for (ConferenceDTO conferenceDTO : conferenceRoomEntity.get().getConferences()) {
                this.conferenceService.deleteConference(conferenceDTO.getId());
            }
            this.conferenceRoomService.deleteRoom(roomId);
        }
    }

    @RequestMapping(value = "/{roomId}/conferences/{conferenceId}", method = RequestMethod.DELETE)
    public void deleteConference(@PathVariable Long roomId, @PathVariable Long conferenceId){
        this.conferenceService.deleteConference(conferenceId);
    }
}

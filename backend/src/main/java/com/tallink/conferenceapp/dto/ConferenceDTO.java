package com.tallink.conferenceapp.dto;

import java.util.Date;
import java.util.List;

public class ConferenceDTO extends AbstractDTO {
    private String conferenceName;

    private Date conferenceDateTime;

    private Long roomId;

    private List<ParticipantDTO> participants;

    public String getConferenceName() {
        return this.conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Date getConferenceDateTime() {
        return this.conferenceDateTime;
    }

    public void setConferenceDateTime(Date conferenceDateTime) {
        this.conferenceDateTime = conferenceDateTime;
    }

    public List<ParticipantDTO> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public ConferenceDTO(){

    }

    public ConferenceDTO(String conferenceName, Date conferenceDateTime){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateTime);
    }
    public ConferenceDTO(String conferenceName, Date conferenceDateTime, List<ParticipantDTO> participants){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateTime);
        this.setParticipants(participants);
    }
}

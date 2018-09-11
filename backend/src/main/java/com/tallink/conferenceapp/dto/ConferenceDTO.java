package com.tallink.conferenceapp.dto;

import java.util.Date;
import java.util.List;

public class ConferenceDTO extends AbstractDTO {
    public String conferenceName;

    public Date conferenceDateTime;

    public List<ParticipantDTO> participants;

    public Long roomId;

    public ConferenceDTO(){

    }

    public ConferenceDTO(String conferenceName, Date conferenceDateTime){
        this.conferenceName = conferenceName;
        this.conferenceDateTime = conferenceDateTime;
    }
    public ConferenceDTO(String conferenceName, Date conferenceDateTime, List<ParticipantDTO> participants){
        this.conferenceName = conferenceName;
        this.conferenceDateTime = conferenceDateTime;
        this.participants = participants;
    }
}

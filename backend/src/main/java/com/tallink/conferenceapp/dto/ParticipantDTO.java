package com.tallink.conferenceapp.dto;

import java.util.Date;

public class ParticipantDTO extends AbstractDTO {

    public String participantName;

    public Date participantBirthDay;

    public ParticipantDTO(){

    }

    public ParticipantDTO(String participantName, Date participantBirthDay){
        this.participantName = participantName;
        this.participantBirthDay = participantBirthDay;
    }
}

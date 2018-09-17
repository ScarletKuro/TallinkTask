package com.tallink.conferenceapp.dto;

import java.util.Date;

public class ParticipantDTO extends AbstractDTO {
    private String participantName;

    private Date participantBirthDay;

    public String getParticipantName() {
        return this.participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Date getParticipantBirthDay() {
        return this.participantBirthDay;
    }

    public void setParticipantBirthDay(Date participantBirthDay) {
        this.participantBirthDay = participantBirthDay;
    }

    public ParticipantDTO(){

    }

    public ParticipantDTO(String participantName, Date participantBirthDay){
        this.setParticipantName(participantName);
        this.setParticipantBirthDay(participantBirthDay);
    }
}

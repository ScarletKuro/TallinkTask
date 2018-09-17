package com.tallink.conferenceapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "ParticipantEntity")
@Table(name = "participant")
public class ParticipantEntity {
    @Id
    @GeneratedValue
    @Column(name = "participant_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "participant_name", nullable = false)
    private String participantName;

    @Column(name = "participant_birthday", nullable = false)
    private Date participantBirthDay;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "participants")
    private List<ConferenceEntity> conference = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
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

    public List<ConferenceEntity> getConference() {
        return this.conference;
    }

    public void setConference(List<ConferenceEntity> conference) {
        this.conference = conference;
    }

    public ParticipantEntity(){

    }

    public ParticipantEntity(String participantName, Date participantBirthDay){
        this.setParticipantName(participantName);
        this.setParticipantBirthDay(participantBirthDay);
    }

    public ParticipantEntity(String participantName, Date participantBirthDay, List<ConferenceEntity> conference){
        this.setParticipantName(participantName);
        this.setParticipantBirthDay(participantBirthDay);
        this.setConference(conference);
    }
}

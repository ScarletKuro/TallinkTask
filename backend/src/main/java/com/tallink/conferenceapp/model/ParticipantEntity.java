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
    public Long id;

    @Column(name = "participant_name", nullable = false)
    public String participantName;

    @Column(name = "participant_birthday", nullable = false)
    public Date participantBirthDay;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "participants")
    List<ConferenceEntity> conference = new ArrayList<>();

    public ParticipantEntity(){

    }

    public ParticipantEntity(String participantName, Date participantBirthDay){
        this.participantName = participantName;
        this.participantBirthDay = participantBirthDay;
    }

    public ParticipantEntity(String participantName, Date participantBirthDay, List<ConferenceEntity> conference){
        this.participantName = participantName;
        this.participantBirthDay = participantBirthDay;
        this.conference = conference;
    }
}

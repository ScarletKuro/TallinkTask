package com.tallink.conferenceapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "ConferenceEntity")
@Table(name = "conference")
@Embeddable
public class ConferenceEntity {
    @Id
    @GeneratedValue
    @Column(name = "conference_id", unique = true, nullable = false)
    public Long id;

    @Column(name = "conference_name", nullable = false)
    public String conferenceName;

    @Column(name = "conference_datetime", nullable = false)
    public Date conferenceDateTime;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "conference_participant_association", joinColumns = {
            @JoinColumn(name = "conference_id")},
            inverseJoinColumns = {@JoinColumn(name = "participant_id")})
    public List<ParticipantEntity> participants = new ArrayList<>();

    public void setConferenceRoom(ConferenceRoomEntity conference) {
        this.conferenceRoom = conference;
    }

    public ConferenceRoomEntity getConferenceRoom() {
        return this.conferenceRoom;
    }

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ConferenceRoomEntity conferenceRoom;

    public ConferenceEntity(){
    }

    public ConferenceEntity(String conferenceName, Date conferenceDateTime){
        this.conferenceName = conferenceName;
        this.conferenceDateTime = conferenceDateTime;
    }

    public ConferenceEntity(String conferenceName, Date conferenceDateTime, List<ParticipantEntity> participants, ConferenceRoomEntity conferenceRoomEntity){
        this.conferenceName = conferenceName;
        this.conferenceDateTime = conferenceDateTime;
        this.participants = participants;
        this.setConferenceRoom(conferenceRoomEntity);
    }
}

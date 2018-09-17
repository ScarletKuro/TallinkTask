package com.tallink.conferenceapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "ConferenceEntity")
@Table(name = "conference")
public class ConferenceEntity {
    @Id
    @GeneratedValue
    @Column(name = "conference_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "conference_name", nullable = false)
    private String conferenceName;

    @Column(name = "conference_datetime", nullable = false)
    private Date conferenceDateTime;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "conference_participant_association", joinColumns = {
            @JoinColumn(name = "conference_id")},
            inverseJoinColumns = {@JoinColumn(name = "participant_id")})
    private List<ParticipantEntity> participants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ConferenceRoomEntity conferenceRoom;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<ParticipantEntity> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantEntity> participants) {
        this.participants = participants;
    }

    public ConferenceRoomEntity getConferenceRoom() {
        return this.conferenceRoom;
    }

    public void setConferenceRoom(ConferenceRoomEntity conference) {
        this.conferenceRoom = conference;
    }

    public ConferenceEntity(){
    }

    public ConferenceEntity(String conferenceName, Date conferenceDateTime){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateTime);
    }

    public ConferenceEntity(String conferenceName, Date conferenceDateTime, List<ParticipantEntity> participants, ConferenceRoomEntity conferenceRoomEntity){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateTime);
        this.setParticipants(participants);
        this.setConferenceRoom(conferenceRoomEntity);
    }
}

package com.tallink.conferenceapp.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

import static com.tallink.conferenceapp.config.Constants.MAX_SEATS;

@Entity(name = "ConferenceRoomEntity")
@Table(name = "room")
public class ConferenceRoomEntity {
    @Id
    @GeneratedValue
    @Column(name = "room_id", unique = true, nullable = false)
    public Long id;

    @Column(name = "room_name", nullable = false)
    public String roomName;

    @Column(name = "room_location", nullable = false)
    public String location;

    @Column(name = "room_seats", nullable = false)
    @Max(MAX_SEATS)
    public int seats;

    @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<ConferenceEntity> conferences = new ArrayList<>();

    public ConferenceRoomEntity(){

    }

    public ConferenceRoomEntity(String roomName, String location ,int seats){
        this.roomName = roomName;
        this.location = location;
        this.seats = seats;
    }
    public ConferenceRoomEntity(String roomName, String location ,int seats, List<ConferenceEntity> conferences){
        this.roomName = roomName;
        this.location = location;
        this.seats = seats;
        this.setConferences(conferences);
    }

    public void setConferences(List<ConferenceEntity> conferences) {
        this.conferences.clear();
        if (conferences != null) {
            for (ConferenceEntity conference : conferences){
                this.conferences.add(conference);
                conference.setConferenceRoom(this);
            }
        }
    }

    public List<ConferenceEntity> getConferences() {
        return conferences;
    }
}

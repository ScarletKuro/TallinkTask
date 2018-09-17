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
    private Long id;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "room_location", nullable = false)
    private String location;

    @Column(name = "room_seats", nullable = false)
    @Max(MAX_SEATS)
    private int seats;

    @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<ConferenceEntity> conferences = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
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

    public ConferenceRoomEntity(){

    }

    public ConferenceRoomEntity(String roomName, String location ,int seats){
        this.setRoomName(roomName);
        this.setLocation(location);
        this.setSeats(seats);
    }
    public ConferenceRoomEntity(String roomName, String location ,int seats, List<ConferenceEntity> conferences){
        this.setRoomName(roomName);
        this.setLocation(location);
        this.setSeats(seats);
        this.setConferences(conferences);
    }
}

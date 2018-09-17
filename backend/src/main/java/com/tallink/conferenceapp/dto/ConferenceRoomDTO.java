package com.tallink.conferenceapp.dto;

import javax.validation.constraints.Size;
import java.util.List;

import static com.tallink.conferenceapp.config.Constants.MAX_SEATS;

public class ConferenceRoomDTO extends AbstractDTO {
    private String roomName;

    @Size(min = 1, max = MAX_SEATS)
    private int seats;

    private String location;

    private List<ConferenceDTO> conferences;

    public List<ConferenceDTO> getConferences() {
        return this.conferences;
    }

    public void setConferences(List<ConferenceDTO> conferences) {
        this.conferences = conferences;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ConferenceRoomDTO(){

    }

    public ConferenceRoomDTO(String roomName, String location, int seats){
        this.setRoomName(roomName);
        this.setLocation(location);
        this.setSeats(seats);
    }

    public ConferenceRoomDTO(String roomName, String location, int seats, List<ConferenceDTO> conferences){
        this.setRoomName(roomName);
        this.setLocation(location);
        this.setSeats(seats);
        this.setConferences(conferences);
    }
}

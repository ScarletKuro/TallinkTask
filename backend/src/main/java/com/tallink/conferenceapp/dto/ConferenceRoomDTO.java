package com.tallink.conferenceapp.dto;

import javax.validation.constraints.Size;
import java.util.List;

import static com.tallink.conferenceapp.config.Constants.MAX_SEATS;

public class ConferenceRoomDTO extends AbstractDTO {
    public String roomName;

    @Size(min = 1, max = MAX_SEATS)
    public int seats;

    public String location;

    public List<ConferenceDTO> getConferences() {
        return conferences;
    }

    public void setConferences(List<ConferenceDTO> conferences) {
        this.conferences = conferences;
    }

    private List<ConferenceDTO> conferences;

    public ConferenceRoomDTO(){

    }

    public ConferenceRoomDTO(String roomName, String location, int seats){
        this.roomName = roomName;
        this.location = location;
        this.seats = seats;
    }
}

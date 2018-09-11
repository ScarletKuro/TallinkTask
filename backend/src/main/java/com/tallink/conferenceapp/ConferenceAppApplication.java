package com.tallink.conferenceapp;

import com.tallink.conferenceapp.dto.*;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import com.tallink.conferenceapp.model.Role;
import com.tallink.conferenceapp.model.UserEntity;
import com.tallink.conferenceapp.service.*;
import com.tallink.conferenceapp.settings.AuthenticationSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@CrossOrigin
public class ConferenceAppApplication {

    @Autowired
    @Qualifier("ConferenceRoomServiceImp")
    ConferenceRoomService conferenceRoomService;

    @Autowired
    @Qualifier("UserServiceImp")
    UserService userService;

    @Autowired
    private AuthenticationSettings authenticationSettings;

    public static void main(String[] args) {
        SpringApplication.run(ConferenceAppApplication.class, args);
    }

    @PostConstruct
    public void init() throws Exception {

        for(AuthenticationSettings.UserInfo userInfo : this.authenticationSettings.getUsers()){
            this.userService.saveUser(new UserEntity(userInfo.getUser(), userInfo.getPassword(), userInfo.getRole()));
        }

        List<ParticipantDTO> participantDTOS = Arrays.asList(
                new ParticipantDTO("Name 1", new Date()),
                new ParticipantDTO("Name 2", new Date()),
                new ParticipantDTO("Name 3", new Date()),
                new ParticipantDTO("Name 4", new Date()),
                new ParticipantDTO("Name 5", new Date()),
                new ParticipantDTO("Name 6", new Date()),
                new ParticipantDTO("Name 7", new Date()),
                new ParticipantDTO("Name 8", new Date()),
                new ParticipantDTO("Name 9", new Date()),
                new ParticipantDTO("Name 10", new Date()));

        ConferenceRoomDTO conferenceRoomDTO1 = new ConferenceRoomDTO("Test room", "Some location 1", 124);

        conferenceRoomDTO1.setConferences(Arrays.asList(
                new ConferenceDTO("Test conference 1", new Date(), Arrays.asList(participantDTOS.get(0), participantDTOS.get(2), participantDTOS.get(9))),
                new ConferenceDTO("Test conference 2", new Date(), Arrays.asList(participantDTOS.get(1), participantDTOS.get(3), participantDTOS.get(8))),
                new ConferenceDTO("Test conference 3", new Date(), Arrays.asList(participantDTOS.get(3), participantDTOS.get(4), participantDTOS.get(7))),
                new ConferenceDTO("Test conference 4", new Date(), participantDTOS)));


        ConferenceRoomDTO conferenceRoomDTO2 = new ConferenceRoomDTO("Baltic room", "Some location 2", 124);
        conferenceRoomDTO2.setConferences(Arrays.asList(
                new ConferenceDTO("Baltic conference 1", new Date()),
                new ConferenceDTO("Baltic conference 2", new Date()),
                new ConferenceDTO("Baltic conference 3", new Date()),
                new ConferenceDTO("Baltic conference 4", new Date())));
        conferenceRoomService.saveRoom(conferenceRoomDTO1);
        conferenceRoomService.saveRoom(conferenceRoomDTO2);
    }
}

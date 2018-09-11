package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import com.tallink.conferenceapp.repository.ConferenceRepository;
import com.tallink.conferenceapp.repository.ConferenceRoomRepository;
import com.tallink.conferenceapp.service.ConferenceRoomService;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    public ConferenceRoomEntity toReference(long id) {
        return this.conferenceRoomRepository.findOne(id);
    }

    public long toReference(ConferenceRoomEntity entity) {
        return entity != null ? entity.id : null;
    }
}

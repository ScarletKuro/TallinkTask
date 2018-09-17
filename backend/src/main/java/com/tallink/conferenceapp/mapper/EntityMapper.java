package com.tallink.conferenceapp.mapper;

import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import com.tallink.conferenceapp.repository.ConferenceRoomRepository;
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
        return entity != null ? entity.getId() : null;
    }
}

package com.tallink.conferenceapp.repository;

import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoomEntity, Long> {
    Optional<ConferenceRoomEntity> findById(Long id);

    @Query("select s from ConferenceRoomEntity p inner join p.conferences s where p.id in :roomId")
    Page<ConferenceEntity> findAllConferencesByRoomId(@Param("roomId") Long roomId, Pageable pageable);

    @Query("select s from ConferenceRoomEntity p inner join p.conferences s where p.id in :roomId and s.id = :conferenceId")
    Optional<ConferenceEntity> findConferenceByConferenceIdAndRoomId(@Param("roomId") Long roomId, @Param("conferenceId") Long conferenceId);

    @Modifying
    @Query("delete from ConferenceRoomEntity c where c.id = :id")
    void delete(@Param("id") Long id);
}

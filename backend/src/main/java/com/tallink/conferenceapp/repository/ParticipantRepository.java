package com.tallink.conferenceapp.repository;

import com.tallink.conferenceapp.model.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ParticipantRepository  extends JpaRepository<ParticipantEntity, Long> {
    Optional<ParticipantEntity> findById(Long id);

    @Modifying
    @Query("delete from ParticipantEntity c where c.id = :id")
    void delete(@Param("id") Long id);
}

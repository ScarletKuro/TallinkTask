package com.tallink.conferenceapp.repository;

import com.tallink.conferenceapp.model.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Long> {
    Optional<ConferenceEntity> findById(Long id);

    @Modifying
    @Query("delete from ConferenceEntity c where c.id = :id")
    void delete(@Param("id") Long id);
}

package com.tallink.conferenceapp.service;

import com.tallink.conferenceapp.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserEntity saveUser(UserEntity user);
    List<UserEntity> findUsers();
    void deleteUser(Long id);
}

package com.tallink.conferenceapp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@DiscriminatorColumn(name = "user_type")
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    public Long id;

    @Column(name = "user_name", nullable = false)
    public String userName;

    @Column(name = "user_password", nullable = false)
    public String userPassword;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    public Role role;

    public UserEntity(){

    }

    public UserEntity(String userName, String userPassword, Role role){
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

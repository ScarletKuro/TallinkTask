package com.tallink.conferenceapp.settings;

import com.tallink.conferenceapp.model.Role;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "authentication")
public class AuthenticationSettings {

    public static final class UserInfo {
        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) { this.role = role; }

        private String user;
        private String password;
        private Role role;
    }

    private String key;
    private String clientId;
    private String secret;
    private Integer accessTokenValiditySeconds = 0;
    private Integer refreshTokenValiditySeconds = 0;
    private List<UserInfo> users = new ArrayList<>();

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() { return this.secret; }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getClientId() { return this.clientId; }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public List<UserInfo> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}

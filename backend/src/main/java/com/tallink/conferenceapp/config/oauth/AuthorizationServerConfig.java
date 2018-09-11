package com.tallink.conferenceapp.config.oauth;

import com.tallink.conferenceapp.settings.AuthenticationSettings;
import com.tallink.conferenceapp.settings.CustomJwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private  AuthenticationSettings authenticationSettings;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtTokenStore tokenStore(AuthenticationSettings authenticationSettings) {
        return new JwtTokenStore(this.accessTokenConverter(authenticationSettings));
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(AuthenticationSettings authenticationSettings) {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(authenticationSettings.getKey());
        return jwtAccessTokenConverter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices(AuthenticationSettings authenticationSettings) {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(this.tokenStore(authenticationSettings));
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean
    public CustomJwtTokenEnhancer customJwtTokenEnhancer() {
        return new CustomJwtTokenEnhancer();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer server) {
        server
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient("ui")
                .scopes("api")
                .secret("d3023223c60ae47a0b8fab5e924e19a13a8d82ac")
                .authorizedGrantTypes("authorization_code",
                        "refresh_token", "password")
                .autoApprove(true)
                .accessTokenValiditySeconds(authenticationSettings.getAccessTokenValiditySeconds()).
                refreshTokenValiditySeconds(authenticationSettings.getRefreshTokenValiditySeconds());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(customJwtTokenEnhancer(),accessTokenConverter(authenticationSettings)));

        endpoints
                .tokenStore(tokenStore(authenticationSettings))
                .tokenEnhancer(tokenEnhancerChain)
                .authenticationManager(authenticationManager);
    }
}
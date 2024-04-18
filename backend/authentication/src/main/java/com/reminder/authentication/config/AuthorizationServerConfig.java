package com.reminder.authentication.config;

import com.reminder.authentication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  private final BCryptPasswordEncoder passwordEncoder;
  private final JwtAccessTokenConverter accessTokenConverter;
  private final JwtTokenStore tokenStore;
  private final AuthenticationManager authenticationManager;

  Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired
  public AuthorizationServerConfig(BCryptPasswordEncoder passwordEncoder,
                                   JwtAccessTokenConverter accessTokenConverter,
                                   JwtTokenStore tokenStore,
                                   AuthenticationManager authenticationManager) {
    this.passwordEncoder = passwordEncoder;
    this.accessTokenConverter = accessTokenConverter;
    this.tokenStore = tokenStore;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) {
    log.debug("AuthorizationServerConfig::configure::AuthorizationServerSecurityConfigurer");
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    log.debug("AuthorizationServerConfig::configure::ClientDetailsServiceConfigurer");
    clients
        .inMemory()
        .withClient("reminder_db")
        .secret(passwordEncoder.encode("R3mIndeR5ys7eM"))
        .scopes("read", "write")
        .authorizedGrantTypes("password")
        .accessTokenValiditySeconds(86400);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    log.debug("AuthorizationServerConfig::configure::AuthorizationServerEndpointsConfigurer");
    endpoints
        .authenticationManager(authenticationManager)
        .tokenStore(tokenStore)
        .accessTokenConverter(accessTokenConverter);
  }
}

package com.reminder.authentication.service;

import com.reminder.authentication.client.UserFeignClient;
import com.reminder.authentication.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

  Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired private UserFeignClient userFeignClient;

  public User findByEmail(String email) {
    log.debug("UserService::findByEmail");
    User user = userFeignClient.findByEmail(email).getBody();
    if (user == null) {
      throw new IllegalArgumentException("Email not found");
    }
    return user;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.debug("UserService::loadUserByUsername");
    User user = userFeignClient.findByEmail(username).getBody();
    if (user == null) {
      throw new UsernameNotFoundException("Email not found");
    }
    return user;
  }
}

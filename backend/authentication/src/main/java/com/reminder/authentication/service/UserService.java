package com.reminder.authentication.service;

import com.reminder.authentication.entity.User;
import com.reminder.authentication.feignclient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final UserFeignClient userFeignClient;

  @Autowired
  public UserService(UserFeignClient userFeignClient) {
    this.userFeignClient = userFeignClient;
  }

  public User findByEmail(String email) {
    User user = userFeignClient.findByEmail(email).getBody();
    if (user == null) {
      throw new IllegalArgumentException("Email not found");
    }
    return user;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userFeignClient.findByEmail(username).getBody();
    if (user == null) {
      throw new UsernameNotFoundException("Email not found");
    }
    return user;
  }
}

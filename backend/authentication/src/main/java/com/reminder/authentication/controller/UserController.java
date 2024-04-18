package com.reminder.authentication.controller;

import com.reminder.authentication.entity.User;
import com.reminder.authentication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired private UserService userService;

  @GetMapping("/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    log.debug("UserController::findByEmail");
    try {
      User user = userService.findByEmail(email);
      return ResponseEntity.ok(user);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}

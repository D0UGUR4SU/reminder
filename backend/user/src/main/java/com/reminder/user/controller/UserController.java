package com.reminder.user.controller;

import com.reminder.user.entity.User;
import com.reminder.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository repository;

  @Autowired
  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable String id) {
    User user = repository.findById(id).get();
    return ResponseEntity.ok(user);
  }

  @GetMapping("/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    User user = repository.findByEmail(email);
    return ResponseEntity.ok(user);
  }
}

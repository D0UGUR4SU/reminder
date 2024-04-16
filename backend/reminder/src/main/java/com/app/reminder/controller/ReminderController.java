package com.app.reminder.controller;

import java.util.List;

import com.app.reminder.entity.Reminder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.reminder.repository.ReminderRepository;

@RefreshScope
@RestController
@RequestMapping("/reminders")
public class ReminderController {

  private final ReminderRepository reminderRepository;

  @Autowired
  public ReminderController(Environment env, ReminderRepository reminderRepository) {
    this.reminderRepository = reminderRepository;
  }

  @GetMapping("/configs")
  public ResponseEntity<Void> getConfigs() {
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<Reminder>> findAll() {
    List<Reminder> list = reminderRepository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Reminder> findById(@PathVariable String id) {
    Reminder reminder = reminderRepository.findById(id).get();
    return ResponseEntity.ok(reminder);
  }
}

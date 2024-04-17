package com.reminder.user.entity.dto;

import java.time.Instant;

import com.reminder.user.enums.Priority;
import lombok.Data;

@Data
public class ReminderDto {
  private Long id;
  private Long userId;
  private String name;
  private String description;
  private Instant dueDate;
  private Priority priority;
  private UserDto userDto;
}

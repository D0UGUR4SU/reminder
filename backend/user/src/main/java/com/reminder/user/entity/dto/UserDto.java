package com.reminder.user.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
  private Long id;
  private String name;
  private String email;
  private String password;
  private List<ReminderDto> reminders;
}

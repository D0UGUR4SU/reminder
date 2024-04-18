package com.reminder.user.mapper;

import com.reminder.user.entity.Reminder;
import com.reminder.user.entity.dto.ReminderDto;

import java.util.List;
import java.util.stream.Collectors;

public class ReminderMapper {

  private ReminderMapper() {}

  public static ReminderDto mapToReminderDto(Reminder reminder, Long userId) {
    ReminderDto reminderDto = new ReminderDto();
    reminderDto.setId(reminder.getId());
    reminderDto.setUserId(userId);
    reminderDto.setDescription(reminder.getDescription());
    reminderDto.setDueDate(reminder.getDueDate());
    reminderDto.setPriority(reminder.getPriority());
    return reminderDto;
  }

  public static List<ReminderDto> mapToReminderDtoList(List<Reminder> reminders, Long userId) {
    return reminders.stream()
        .map(reminder -> mapToReminderDto(reminder, userId))
        .collect(Collectors.toList());
  }

  public static Reminder mapToReminder(ReminderDto reminderDto, Long userId) {
    Reminder reminder = new Reminder();
    reminder.setId(reminderDto.getId());
    reminder.setUserId(userId);
    reminder.setDescription(reminderDto.getDescription());
    reminder.setDueDate(reminderDto.getDueDate());
    reminder.setPriority(reminderDto.getPriority());
    return reminder;
  }

  public static List<Reminder> mapToReminderList(List<ReminderDto> remindersDto, Long userId) {
    return remindersDto.stream()
        .map(reminderDto -> mapToReminder(reminderDto, userId))
        .collect(Collectors.toList());
  }
}

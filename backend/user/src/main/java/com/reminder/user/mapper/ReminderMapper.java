package com.reminder.user.mapper;

import com.reminder.user.entity.Reminder;
import com.reminder.user.entity.dto.ReminderDto;

import java.util.List;
import java.util.stream.Collectors;

public class ReminderMapper {

  private ReminderMapper() {}

  public static ReminderDto mapToReminderDto(Reminder reminder) {
    ReminderDto reminderDto = new ReminderDto();
    reminderDto.setId(reminder.getId());
    reminderDto.setName(reminder.getName());
    reminderDto.setDescription(reminder.getDescription());
    reminderDto.setDueDate(reminder.getDueDate());
    reminderDto.setPriority(reminder.getPriority());
    return reminderDto;
  }

  public static List<ReminderDto> mapToReminderDtoList(List<Reminder> reminders) {
    return reminders.stream()
        .map(ReminderMapper::mapToReminderDto)
        .collect(Collectors.toList());
  }

  public static Reminder mapToReminder(ReminderDto reminderDto) {
    Reminder reminder = new Reminder();
    reminder.setId(reminderDto.getId());
    reminder.setName(reminderDto.getName());
    reminder.setDescription(reminderDto.getDescription());
    reminder.setDueDate(reminderDto.getDueDate());
    reminder.setPriority(reminderDto.getPriority());
    return reminder;
  }

  public static List<Reminder> mapToReminderList(List<ReminderDto> remindersDto) {
    return remindersDto.stream()
        .map(ReminderMapperDto::mapToReminder)
        .collect(Collectors.toList());
  }
}

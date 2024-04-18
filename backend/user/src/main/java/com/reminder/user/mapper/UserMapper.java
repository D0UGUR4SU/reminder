package com.reminder.user.mapper;

import com.reminder.user.entity.User;
import com.reminder.user.entity.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

  private UserMapper() {}

  public static UserDto mapToUserDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    userDto.setReminders(
        user.getReminders().stream()
            .map(reminder -> ReminderMapper.mapToReminderDto(reminder, user.getId()))
            .collect(Collectors.toList()));
    return userDto;
  }

  public static List<UserDto> mapToUserDtoList(List<User> users) {
    return users.stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
  }

  public static User mapToUser(UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setPassword(userDto.getPassword());
    user.setReminders(
        userDto.getReminders().stream()
            .map(reminderDto -> ReminderMapper.mapToReminder(reminderDto, user.getId()))
            .collect(Collectors.toList()));
    return user;
  }
}

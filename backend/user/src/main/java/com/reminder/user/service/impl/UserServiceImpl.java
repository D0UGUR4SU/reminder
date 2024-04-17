package com.reminder.user.service.impl;

import com.reminder.user.entity.Reminder;
import com.reminder.user.entity.User;
import com.reminder.user.entity.dto.ReminderDto;
import com.reminder.user.entity.dto.UserDto;
import com.reminder.user.exception.ResourceNotFoundException;
import com.reminder.user.exception.UserAlreadyExistsException;
import com.reminder.user.mapper.ReminderMapper;
import com.reminder.user.mapper.UserMapper;
import com.reminder.user.repository.ReminderRepository;
import com.reminder.user.repository.UserRepository;
import com.reminder.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.reminder.user.constants.Constants.REMINDER;
import static com.reminder.user.constants.Constants.REMINDER_ID;
import static com.reminder.user.constants.Constants.USER;
import static com.reminder.user.constants.Constants.USER_ID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

  private final ReminderRepository reminderRepository;
  private UserRepository userRepository;

  @Override
  public void createUser(UserDto userDto) {
    User user = UserMapper.mapToUser(userDto);
    Optional<User> optionalCustomer =
        Optional.ofNullable(userRepository.findUserByEmail(user.getEmail()));

    if (optionalCustomer.isPresent()) {
      throw new UserAlreadyExistsException(
          "Customer already registered with given E-mail: " + userDto.getEmail());
    }

    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setReminders(ReminderMapper.mapToReminderList(userDto.getReminders()));

    userRepository.save(user);
  }

  @Override
  public List<UserDto> getUser() {
    List<User> users = userRepository.findAll();
    return UserMapper.mapToUserDtoList(users);
  }

  @Override
  public UserDto getUserById(Long id) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(USER, USER_ID, id.toString()));

    reminderRepository.findByUserId(user.getId());

    return UserMapper.mapToUserDto(user);
  }

  @Override
  public boolean updateUser(UserDto userDto) {
    boolean isUpdated = false;

    List<ReminderDto> remindersDto = userDto.getReminders();
    if (remindersDto != null && !remindersDto.isEmpty()) {
      for (ReminderDto reminderDto : remindersDto) {
        Long reminderId = reminderDto.getId();
        Reminder reminder =
            reminderRepository
                .findById(reminderId)
                .orElseThrow(
                    () ->
                        new ResourceNotFoundException(
                            REMINDER, REMINDER_ID, reminderId.toString()));

        ReminderMapper.mapToReminder(reminderDto);
        reminderRepository.save(reminder);
      }

      Long userId = remindersDto.get(0).getUserId();
      User user =
          userRepository
              .findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException(USER, USER_ID, userId.toString()));

      UserMapper.mapToUser(userDto);
      userRepository.save(user);

      isUpdated = true;
    }

    return isUpdated;
  }

  @Override
  public boolean deleteUser(Long id) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(USER, USER_ID, id.toString()));

    reminderRepository.deleteRemindersByUserId(user.getId());
    userRepository.deleteById(user.getId());
    return true;
  }
}

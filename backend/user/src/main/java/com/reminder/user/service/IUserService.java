package com.reminder.user.service;

import com.reminder.user.entity.dto.UserDto;

import java.util.List;

public interface IUserService {

  void createUser(UserDto userDto);

  List<UserDto> getUser();

  UserDto getUserById(Long id);

  boolean updateUser(UserDto userDto);

  boolean deleteUser(Long id);
}

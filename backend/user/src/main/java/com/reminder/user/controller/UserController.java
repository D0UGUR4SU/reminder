package com.reminder.user.controller;

import com.reminder.user.entity.dto.ResponseDto;
import com.reminder.user.entity.dto.UserDto;
import com.reminder.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.reminder.user.constants.Constants.MESSAGE_200;
import static com.reminder.user.constants.Constants.MESSAGE_201;
import static com.reminder.user.constants.Constants.MESSAGE_500;
import static com.reminder.user.constants.Constants.STATUS_200;
import static com.reminder.user.constants.Constants.STATUS_201;
import static com.reminder.user.constants.Constants.STATUS_500;

@RestController
@RequestMapping("/users")
public class UserController {

  private final IUserService iUserService;

  @Autowired
  public UserController(IUserService iUserService) {
    this.iUserService = iUserService;
  }

  @PostMapping
  public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
    iUserService.createUser(userDto);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ResponseDto(STATUS_201, MESSAGE_201));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
    UserDto userDto = iUserService.getUserById(id);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(userDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
    UserDto userRetrieved = iUserService.getUserById(id);
    if (userRetrieved == null) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .build();
    }

    boolean isUpdated = iUserService.updateUser(userDto);
    if (isUpdated) {
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(new ResponseDto(STATUS_200, MESSAGE_200));
    } else {
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(new ResponseDto(STATUS_500, MESSAGE_500));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long id) {
    boolean isDeleted = iUserService.deleteUser(id);
    if (isDeleted) {
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(new ResponseDto(STATUS_200, MESSAGE_200));
    } else {
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(new ResponseDto(STATUS_500, MESSAGE_500));
    }
  }
}

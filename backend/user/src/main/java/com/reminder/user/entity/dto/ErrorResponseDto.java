package com.reminder.user.entity.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
  private String apiPath;
  private HttpStatus errorCode;
  private String errorMsg;
  private Instant errorTime;
}

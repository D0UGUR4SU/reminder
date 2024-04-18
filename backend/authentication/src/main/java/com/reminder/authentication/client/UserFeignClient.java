package com.reminder.authentication.client;

import com.reminder.authentication.config.AppConfig;
import com.reminder.authentication.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user", path = "/users", configuration = AppConfig.class)
public interface UserFeignClient {

  @GetMapping("/search")
  ResponseEntity<User> findByEmail(@RequestParam String email);
}

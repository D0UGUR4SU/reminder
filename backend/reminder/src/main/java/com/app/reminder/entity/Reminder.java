package com.app.reminder.entity;

import com.app.reminder.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reminders")
public class Reminder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;
  private String name;
  private String description;
  private Instant dueDate;
  private Priority priority;
}

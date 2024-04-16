package com.app.reminder.entity;

import com.app.reminder.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
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

  @BsonId
  private String id;
  private String name;
  private String description;
  private Instant dueDate;
  private Priority priority;
}

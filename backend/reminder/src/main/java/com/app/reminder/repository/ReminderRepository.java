package com.app.reminder.repository;

import com.app.reminder.entity.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReminderRepository extends MongoRepository<Reminder, String> {}

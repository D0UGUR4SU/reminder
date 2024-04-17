package com.reminder.user.repository;

import com.reminder.user.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

  List<Reminder> findByUserId(Long id);

  @Transactional
  @Modifying
  void deleteRemindersByUserId(Long userId);
}

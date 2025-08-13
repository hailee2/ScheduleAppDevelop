package org.example.scheduleappdevelop.repository;

import org.example.scheduleappdevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

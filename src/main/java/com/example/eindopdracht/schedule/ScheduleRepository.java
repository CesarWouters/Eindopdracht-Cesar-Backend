package com.example.eindopdracht.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findByDate(LocalDate date);
}

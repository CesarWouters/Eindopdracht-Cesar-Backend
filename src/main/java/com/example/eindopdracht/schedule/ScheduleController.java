package com.example.eindopdracht.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<ScheduleDto> findScheduleByDate(@RequestParam("date") LocalDate date) {
        return ResponseEntity.ok(scheduleService.findScheduleByDate(date));
    }
    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        return ResponseEntity.created(null).body(scheduleService.createSchedule(scheduleDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable ("id") Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}

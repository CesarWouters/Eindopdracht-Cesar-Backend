package com.example.eindopdracht.schedule;

import com.example.eindopdracht.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleDto createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setDate(scheduleDto.getDate());
        scheduleRepository.save(schedule);
        return scheduleDto;
    }

    public void deleteSchedule(Long id) {
        if (scheduleRepository.existsById(id)){
        scheduleRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("geen rooster gevonden");
        }
    }

    public ScheduleDto scheduleToDto(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setDate(schedule.getDate());
        scheduleDto.setEmployeeName(schedule.getEmployeeName());
        return scheduleDto;
    }

    public ScheduleDto findScheduleByDate(LocalDate date) {
        Schedule schedule = scheduleRepository.findByDate(date);
        ScheduleDto scheduleDto = scheduleToDto(schedule);
        return scheduleDto;
    }

}

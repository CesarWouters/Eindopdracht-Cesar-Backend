package com.example.eindopdracht.schedule;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ScheduleDto {
    public Long id;
    public LocalDate date;
    public String employeeName;

}

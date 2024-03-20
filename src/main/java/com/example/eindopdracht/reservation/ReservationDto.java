package com.example.eindopdracht.reservation;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ReservationDto {
    public Long id;
    public LocalDate date;
    public Integer timeFrame;
    public Integer table;
    public Integer persons;
    public String name;
    public String food;
    public String comment;


}

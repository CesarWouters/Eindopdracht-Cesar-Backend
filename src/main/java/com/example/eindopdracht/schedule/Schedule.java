package com.example.eindopdracht.schedule;

import com.example.eindopdracht.table.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private String employeeName;


    @ManyToMany(mappedBy = "schedules")
    private Set<Table> tables = new HashSet<>();

}

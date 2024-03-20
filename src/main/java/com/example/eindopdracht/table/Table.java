package com.example.eindopdracht.table;

import com.example.eindopdracht.schedule.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Table {

    @Id
    private Integer tableNumber;
    private Integer capacity;

    @ManyToMany
    private Set<Schedule> schedules = new HashSet<>();

}

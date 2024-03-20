package com.example.eindopdracht.reservation;

import com.example.eindopdracht.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private Integer timeFrame;
    private Integer persons;
    private String name;
    private String food;
    private String comment;
    private Integer table;

    @ManyToOne
    private User user;

}

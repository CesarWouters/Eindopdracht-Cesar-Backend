package com.example.eindopdracht.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllReservationsByDate(String date);
    List<Reservation> findAllReservationsByTimeFrame(Integer timeFrame);
    Reservation findReservationByName(String name);
    List<Reservation> findAllReservationsByDateAndTimeFrame(String date, Integer timeFrame);
}

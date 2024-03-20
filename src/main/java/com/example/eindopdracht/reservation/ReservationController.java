package com.example.eindopdracht.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> findAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }
    @GetMapping("/{date}")
    public ResponseEntity<List<ReservationDto>> findReservationsByDate(@PathVariable ("date") LocalDate date){
        return ResponseEntity.ok(reservationService.findReservationsByDate(date));
    }
    @GetMapping("/{timeframe}")
    public ResponseEntity<List<ReservationDto>> findReservationsByTimeFrame(@PathVariable ("timeframe") Integer timeFrame){
        return ResponseEntity.ok(reservationService.findReservationsByTimeFrame(timeFrame));
    }
    @GetMapping("/{name}")
    public ResponseEntity<ReservationDto> findReservationByName(@PathVariable ("name") String name){
        return ResponseEntity.ok(reservationService.findReservationByName(name));
    }
    @GetMapping("/{date}/{timeframe}")
    public ResponseEntity<List<ReservationDto>> findReservationsByDateAndTimeFrame(@PathVariable ("date") LocalDate date, @PathVariable ("timeframe") Integer timeFrame){
        return ResponseEntity.ok(reservationService.findReservationsByDateAndTimeFrame(date, timeFrame));
    }

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.created(null).body(reservationService.createReservation(reservationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReservation(@PathVariable ("id") Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}

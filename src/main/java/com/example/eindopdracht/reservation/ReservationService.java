package com.example.eindopdracht.reservation;

import com.example.eindopdracht.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
            reservation.setDate(String.valueOf(reservationDto.getDate()));
            reservation.setTimeFrame(reservationDto.getTimeFrame());
            reservation.setTable(reservationDto.getTable());
            reservation.setPersons(reservationDto.getPersons());
            reservation.setName(reservationDto.getName());
            reservation.setFood(reservationDto.getFood());
            reservation.setComment(reservationDto.getComment());
        reservationRepository.save(reservation);
        return reservationDto;
    }

    public List<ReservationDto> findAllReservations() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return reservationListToDtoList(reservationList);
    }

    public List<ReservationDto> findReservationsByDate(LocalDate date) {
        List<Reservation> reservationList = reservationRepository.findAllReservationsByDate(String.valueOf(date));
        return reservationListToDtoList(reservationList);
    }

    public List<ReservationDto> findReservationsByTimeFrame(Integer timeFrame) {
        List<Reservation> reservationList = reservationRepository.findAllReservationsByTimeFrame(timeFrame);
        return reservationListToDtoList(reservationList);
    }

    public List<ReservationDto> findReservationsByDateAndTimeFrame(LocalDate date, Integer timeFrame) {
        List<Reservation> reservationList = reservationRepository.findAllReservationsByDateAndTimeFrame(String.valueOf(date), timeFrame);
        return reservationListToDtoList(reservationList);
    }

    public ReservationDto findReservationByName(String name) {
        if (reservationRepository.findReservationByName(name) == null) {
            throw new RecordNotFoundException("geen reservering gevonden");
        }else {
            Reservation reservation = reservationRepository.findReservationByName(name);
            return reservationToDto(reservation);
        }
    }

    public void deleteReservation(Long id) {
        if (reservationRepository.findById(id).isEmpty()) {
            throw new RecordNotFoundException("geen reservering gevonden");
        }else {
            reservationRepository.deleteById(id);
        }
    }

    public List<ReservationDto> reservationListToDtoList(List<Reservation> reservations) {
        List<ReservationDto> reservationDtoList = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationDto reservationDto = reservationToDto(reservation);
            reservationDtoList.add(reservationDto);
        }
        return reservationDtoList;
    }

    public ReservationDto reservationToDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setDate(LocalDate.parse(reservation.getDate()));
        reservationDto.setTimeFrame(reservation.getTimeFrame());
        reservationDto.setTable(reservation.getTable());
        reservationDto.setPersons(reservation.getPersons());
        reservationDto.setName(reservation.getName());
        reservationDto.setFood(reservation.getFood());
        reservationDto.setComment(reservation.getComment());
        return reservationDto;
    }

    public Reservation dtoToReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setDate(String.valueOf(reservationDto.getDate()));
        reservation.setTimeFrame(reservationDto.getTimeFrame());
        reservation.setTable(reservationDto.getTable());
        reservation.setPersons(reservationDto.getPersons());
        reservation.setName(reservationDto.getName());
        reservation.setFood(reservationDto.getFood());
        reservation.setComment(reservationDto.getComment());
        return reservation;
    }

}

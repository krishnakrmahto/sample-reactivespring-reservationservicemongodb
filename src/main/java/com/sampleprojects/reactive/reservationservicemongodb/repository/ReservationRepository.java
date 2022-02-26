package com.sampleprojects.reactive.reservationservicemongodb.repository;

import com.sampleprojects.reactive.reservationservicemongodb.entity.Reservation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {
}

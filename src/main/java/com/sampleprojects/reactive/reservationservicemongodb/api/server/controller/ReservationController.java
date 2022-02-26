package com.sampleprojects.reactive.reservationservicemongodb.api.server.controller;

import com.sampleprojects.reactive.reservationservicemongodb.entity.Reservation;
import com.sampleprojects.reactive.reservationservicemongodb.service.SampleReservationService;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

  private final SampleReservationService service;

  @GetMapping
  public Publisher<Reservation> getAll() {
    return service.getAllReservations();
  }
}

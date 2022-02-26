package com.sampleprojects.reactive.reservationservicemongodb.api.server.controller;

import com.sampleprojects.reactive.reservationservicemongodb.api.server.response.ReservationDetailsResponse;
import com.sampleprojects.reactive.reservationservicemongodb.entity.Reservation;
import com.sampleprojects.reactive.reservationservicemongodb.service.SampleReservationService;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
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

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/reservation-details-stream")
  public Publisher<ReservationDetailsResponse> getAllReservationDetailsStream() {
    return service.getReservationDetailStream();
  }
}

package com.sampleprojects.reactive.reservationservicemongodb.service;

import com.sampleprojects.reactive.reservationservicemongodb.entity.Reservation;
import com.sampleprojects.reactive.reservationservicemongodb.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleReservationService {

  private final ReservationRepository repository;


  public Publisher<Reservation> getAllReservations() {
    return repository.findAll();
  }

  @EventListener(ApplicationStartedEvent.class)
  public void initialize() {

    Flux<Reservation> saveDocuments = Flux.just("Krishna", "is", "Spiderman")
        .map(name -> Reservation.builder().name(name).build())
        .flatMap(repository::save);

    repository.deleteAll()
        .thenMany(saveDocuments)
        .thenMany(repository.findAll())
        .subscribe(reservation -> log.info(String.valueOf(reservation)));
  }
}

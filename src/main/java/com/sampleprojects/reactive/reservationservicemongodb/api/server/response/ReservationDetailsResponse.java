package com.sampleprojects.reactive.reservationservicemongodb.api.server.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReservationDetailsResponse {

  String name;
  LocalDateTime time;
}
